package clone.airbnbpg.member.api;

import clone.airbnbpg.member.Member;
import clone.airbnbpg.member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberReaderTest {

    @Autowired
    MemberReader memberReader;

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        for (int i = 1; i <= 10; i++) {
            memberRepository.save(new Member("test" + i));
        }
    }

    @Test
    void isExistMember() {
        boolean existMember = memberReader.isExistMember("test1");
        assertThat(existMember).isTrue();
    }
}