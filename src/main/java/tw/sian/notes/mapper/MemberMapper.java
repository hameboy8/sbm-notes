package tw.sian.notes.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tw.sian.notes.model.Member;

import java.util.List;

public interface MemberMapper {
    @Select("SELECT * FROM MEMBER")
    @Results({
            @Result(property = "memberId",  column = "MEMBER_ID"),
            @Result(property = "memberAccount", column = "MEMBER_ACCOUNT"),
            @Result(property = "memberPassword", column = "MEMBER_PASSWORD"),
            @Result(property = "memberName", column = "MEMBER_NAME"),
            @Result(property = "memberStatus", column = "MEMBER_STATUS"),
            @Result(property = "createTime", column = "CREATE_TIME"),
            @Result(property = "updateTime", column = "UPDATE_TIME")
    })
    public List<Member> selectAll();
}
