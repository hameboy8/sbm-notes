package tw.sian.notes.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tw.sian.notes.NotesApplication;
import tw.sian.notes.model.Member;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { NotesApplication.class })
public class MemberMapperTest {

    private MemberMapper memberMapper;
    @Autowired
    public void setMemberMapper(MemberMapper memberMapper){
        this.memberMapper = memberMapper;
    }

//    @Test
    public void selectAllTest() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        List<Member> list = memberMapper.selectAll();
        System.out.println(list.toString());
        Iterator<Member> iter = list.iterator();
        while (iter.hasNext()){
            Member tempM = iter.next();
            System.out.println("tempM Name : " + tempM.getMemberName());
            System.out.println("tempM CreateTime : " + simpleDateFormat.format( tempM.getCreateTime()) );
        }
    }
//    @Test
    public void selectOneByAccountTest() {
        String accountName = "ACC";
        Member member = memberMapper.selectOneByAccount(accountName);
        assertEquals(member.getMemberAccount(), accountName);
    }
//    @Test
    public void insertTest() {
        Member member = new Member();
        Date today = new Date();
        member.setMemberAccount("Jeff");
        member.setMemberName("Jeff Hsu");
        member.setMemberPassword("1234");
        member.setMemberStatus("1");
        member.setCreateTime(today);
        member.setUpdateTime(today);
        memberMapper.insert(member);
        System.out.println(member.getMemberId());
    }
//    @Test
    public void updateTest() {
        Member member = memberMapper.selectOneByAccount("Jeff");
        Date today = new Date();
        member.setMemberName("Jeff Hsuuu");
        member.setMemberPassword("12344321");
        member.setUpdateTime(today);
        memberMapper.update(member);
    }
//    @Test
    public void logicDeleteTest(){
        Member member = memberMapper.selectOneByAccount("Jeff");
        Date today = new Date();
        member.setUpdateTime(today);
        memberMapper.logicDelete(member);
    }
}
