package clone.airbnbpg.member.api;

import clone.airbnbpg.member.Member;
import clone.airbnbpg.member.web.MemberReq;
import clone.airbnbpg.member.web.MemberRes;
import org.springframework.stereotype.Service;

@Service
public record MemberService(MemberWriter memberWriter) {

    public MemberRes saveMember(MemberReq memberReq) {
        Member member = memberReq.toEntity();

        Member savedMember = memberWriter.saveMember(member);

        return MemberRes.fromEntity(savedMember);
    }
}
