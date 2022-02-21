package clone.airbnbpg.member.repository;

import clone.airbnbpg.member.Member;

import java.util.Optional;

public interface MemberQueryRepository {

    Optional<Member> findByUsername(String username);
}
