package clone.airbnbpg.member.repository;

import clone.airbnbpg.member.Member;

import java.util.Optional;

public interface MemberTestRepo {

    Optional<Member> findByUsername(String username);
}
