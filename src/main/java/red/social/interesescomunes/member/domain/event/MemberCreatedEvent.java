package red.social.interesescomunes.member.domain.event;

import red.social.interesescomunes.member.domain.model.Member;

public class MemberCreatedEvent {
    private final Member member;

    public MemberCreatedEvent(Member member) {
        this.member = member;
    }

    public Member getOwner() {
        return member;
    }
}
