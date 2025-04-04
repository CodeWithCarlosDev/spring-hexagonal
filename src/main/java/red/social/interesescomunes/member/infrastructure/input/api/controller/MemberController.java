package red.social.interesescomunes.member.infrastructure.input.api.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import red.social.interesescomunes.member.application.input.IMemberServicePort;
import red.social.interesescomunes.member.domain.model.Member;
import red.social.interesescomunes.member.infrastructure.input.api.dto.request.MemberRequest;
import red.social.interesescomunes.member.infrastructure.input.api.dto.response.MemberResponse;
import red.social.interesescomunes.member.infrastructure.input.api.mapper.IMemberRestMappert;

import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {
    private final IMemberServicePort service;
    private final IMemberRestMappert mapper;

    public MemberController(IMemberServicePort service, IMemberRestMappert mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<MemberResponse>> findAllMembers() {
        List<Member> members = this.service.findAllMembers();
        List<MemberResponse> responses = this.mapper.toUserResponseList(members);
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<MemberResponse> findMemberById(@PathVariable Long id) {
        Member member = this.service.findMemberById(id);
        MemberResponse response = this.mapper.toUserResponse(member);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<MemberResponse> createMember(@Valid @RequestBody MemberRequest memberRequest) {
        Member member = this.mapper.toDomain(memberRequest);
        Member savedMember = this.service.createMember(member);
        MemberResponse response = this.mapper.toUserResponse(savedMember);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MemberResponse> updateMember(@PathVariable Long id, @Valid @RequestBody MemberRequest memberRequest) {
        Member member = this.mapper.toDomain(memberRequest);
        Member updatedMember = this.service.updateMember(id, member);
        MemberResponse response = this.mapper.toUserResponse(updatedMember);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMemberById(@PathVariable Long id) {
        this.service.deleteMemberById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Miembro eliminado.");
    }
}
