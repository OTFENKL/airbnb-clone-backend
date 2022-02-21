package clone.airbnbpg.member.web;

import clone.airbnbpg.member.Member;

public record MemberRes(String username) {

    public static MemberRes fromEntity(Member member) {
        return new MemberRes(member.getUsername());
    }
}
