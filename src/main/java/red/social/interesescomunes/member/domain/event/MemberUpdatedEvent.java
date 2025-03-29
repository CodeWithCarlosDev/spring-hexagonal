package red.social.interesescomunes.member.domain.event;

import red.social.interesescomunes.member.domain.model.Member;

public class MemberUpdatedEvent {
    private final Member member;

    public MemberUpdatedEvent(Member member) {
        this.member = member;
    }

    public Member getOwner() {
        return member;
    }
}
