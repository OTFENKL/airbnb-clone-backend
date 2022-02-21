package clone.airbnbpg.member.web;

import clone.airbnbpg.member.Member;

public record MemberReq(String username) {

    public Member toEntity() {
        return new Member(username);
    }
}
