package clone.airbnbpg.member.repository;

import clone.airbnbpg.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberQueryRepository, MemberTestRepo {
}
