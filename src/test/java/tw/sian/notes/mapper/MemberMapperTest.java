package tw.sian.notes.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tw.sian.notes.NotesApplication;
import tw.sian.notes.model.Member;

import java.text.SimpleDateFormat;
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

    @Test
    public void testSelectAllReturnExpectedList() {
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

}
