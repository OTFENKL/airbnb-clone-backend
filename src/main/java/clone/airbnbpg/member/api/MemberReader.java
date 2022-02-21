package clone.airbnbpg.member.api;

import clone.airbnbpg.member.Member;
import clone.airbnbpg.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Component
public class MemberReader {

    private final MemberRepository memberRepository;

    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    public boolean isExistMember(String username) {
        Optional<Member> findMember = memberRepository.findByUsername(username);
        return findMember.isPresent();
    }
}
