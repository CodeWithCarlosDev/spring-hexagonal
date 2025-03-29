package red.social.interesescomunes.member.domain.event;

import red.social.interesescomunes.member.domain.model.Member;

public class MemberDeletedEvent {
    private final Member member;

    public MemberDeletedEvent(Member member) {
        this.member = member;
    }

    public Member getOwner() {
        return member;
    }
}
