package tw.sian.notes.mapper;

import tw.sian.notes.model.Member;

import java.util.List;

public interface MemberMapper {
    List<Member> selectAll();
    Member selectOneByAccount(String memberAccount);
    void insert(Member member);
    void update(Member member);
    void logicDelete(Member member);
}
