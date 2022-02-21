package clone.airbnbpg.member.repository;

import clone.airbnbpg.member.Member;
import clone.airbnbpg.member.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class MemberQueryRepositoryImpl implements MemberQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Member> findByUsername(String username) {
        Member member = queryFactory.selectFrom(QMember.member)
                .where(QMember.member.username.eq(username))
                .fetchOne();

        return Optional.ofNullable(member);
    }
}
