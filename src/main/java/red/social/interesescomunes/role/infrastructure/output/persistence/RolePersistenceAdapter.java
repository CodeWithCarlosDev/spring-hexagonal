package red.social.interesescomunes.role.infrastructure.output.persistence;

import org.springframework.stereotype.Component;
import red.social.interesescomunes.role.application.output.IRolePersistencePort;
import red.social.interesescomunes.role.domain.model.Role;
import red.social.interesescomunes.role.infrastructure.output.persistence.mapper.IRolePersistenceMapper;
import red.social.interesescomunes.role.infrastructure.output.persistence.mysql.entity.RoleEntity;
import red.social.interesescomunes.role.infrastructure.output.persistence.mysql.repository.IRoleJpaRepository;

import java.util.List;
import java.util.Optional;

@Component
public class RolePersistenceAdapter implements IRolePersistencePort {
    private final IRoleJpaRepository repository;
    private final IRolePersistenceMapper mapper;

    public RolePersistenceAdapter(IRoleJpaRepository repository, IRolePersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Role> findAll() {
        List<RoleEntity> roleEntities = (List<RoleEntity>) this.repository.findAll();
        return mapper.toDomainList(roleEntities);
    }

    @Override
    public Optional<Role> findById(Long id) {
        return  this.repository.findById(id)
            .map(mapper::toDomain);
    }

    @Override
    public Role save(Role role) {
        RoleEntity roleEntity = mapper.toEntity(role);
        System.out.println("RoleEntity : " + roleEntity);
        RoleEntity savedRole = this.repository.save(roleEntity);
        return mapper.toDomain(savedRole);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
