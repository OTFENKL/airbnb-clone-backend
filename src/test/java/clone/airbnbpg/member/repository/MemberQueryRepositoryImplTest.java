package clone.airbnbpg.member.repository;

import clone.airbnbpg.member.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberQueryRepositoryImplTest {

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        for (int i = 1; i <= 10; i++) {
            memberRepository.save(new Member("test" + i));
        }
    }

    @Test
    void findByUsername() {
        //given
        String username = "test1";

        //when
        Optional<Member> findMember = memberRepository.findByUsername(username);

        //then
        assertThat(findMember.get().getUsername()).isEqualTo(username);
    }
}