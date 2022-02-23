package clone.airbnbpg.member.api;

import clone.airbnbpg.common.exception.member.MemberNotFoundException;
import clone.airbnbpg.member.Member;
import clone.airbnbpg.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Component
public class MemberReader {

    private final MemberRepository memberRepository;

    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(() -> new MemberNotFoundException("해당 사용자를 찾을 수 없습니다."));
    }

    public boolean isExistMember(String username) {
        Optional<Member> findMember = memberRepository.findByUsername(username);
        return findMember.isPresent();
    }
}
