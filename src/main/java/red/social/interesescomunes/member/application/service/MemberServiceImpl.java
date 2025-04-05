package red.social.interesescomunes.member.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import red.social.interesescomunes.member.application.input.IMemberServicePort;
import red.social.interesescomunes.member.application.output.IMemberPersistencePort;
import red.social.interesescomunes.member.domain.event.IMemberDomainEventPublisher;
import red.social.interesescomunes.member.domain.model.Member;
import red.social.interesescomunes.role.application.input.IRoleServicePort;
import red.social.interesescomunes.role.domain.enums.TypeRole;
import red.social.interesescomunes.role.domain.model.Role;
import red.social.interesescomunes.user.domain.exception.UserNotFoundException;
import red.social.interesescomunes.user.domain.model.User;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MemberServiceImpl implements IMemberServicePort {
    private final IMemberPersistencePort repository;
    private final IMemberDomainEventPublisher eventPublisher;
    private final IRoleServicePort roleServicePort;

    public MemberServiceImpl(IMemberPersistencePort repository, IMemberDomainEventPublisher eventPublisher, IRoleServicePort roleServicePort) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
        this.roleServicePort = roleServicePort;
    }

    @Override
    public List<Member> findAllMembers() {
        return this.repository.findAll();
    }

    @Override
    public Member findMemberById(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No se encontró un miembro con el id " + id));
    }

    @Override
    @Transactional
    public Member createMember(Member member) {
        Role role = this.roleServicePort.findRoleByType(TypeRole.MIEMBRO.name());
        User user = member.getUser();
        user.setRoles(List.of(role));
        user.setCreatedAt(LocalDateTime.now());

        member.setStartDate(LocalDateTime.now());
        member.setUser(user);

        // Guardamos y publicamos el evento
        Member memberCreated = this.repository.save(member);
        memberCreated.create(this.eventPublisher);
        return memberCreated;
    }

    @Override
    @Transactional
    public Member updateMember(Long id, Member member) {
        User user = member.getUser();
        Member existingMember = this.repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No se encontró un miembro con el id " + id));

        // Actualizamos los datos del usuario
        existingMember.getUser().setFirstName(user.getFirstName());
        existingMember.getUser().setLastName(user.getLastName());
        existingMember.getUser().setAddress(user.getAddress());
        existingMember.getUser().setEmail(user.getEmail());
        existingMember.getUser().setPassword(user.getPassword());
        existingMember.getUser().setUpdatedAt(LocalDateTime.now());
        existingMember.getUser().setRoles(user.getRoles());
        // Guardamos y publicamos el evento
        Member memberUpdated = this.repository.save(existingMember);
        memberUpdated.update(this.eventPublisher);
        return memberUpdated;
    }

    @Override
    public void deleteMemberById(Long id) {
        Member existingMember = this.repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No se encontró un miembro con el id " + id));

        // Eliminamos y publicamos el evento
        this.repository.delete(existingMember.getId());
        existingMember.delete(this.eventPublisher);
    }
}
