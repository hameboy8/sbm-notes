package tw.sian.notes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.sian.notes.mapper.MemberMapper;
import tw.sian.notes.model.Member;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

@RestController
public class HelloController {


    private MemberMapper memberMapper;

    @Autowired
    public void setMemberMapper(MemberMapper memberMapper){
        this.memberMapper = memberMapper;
    }

    static final Logger logger = LoggerFactory.getLogger(HelloController.class.getName());

    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");

    @GetMapping("/hello")
    public String hello() {
        logger.info("running hello");
        List<Member> list = memberMapper.selectAll();
        Iterator<Member> iter = list.iterator();
        while (iter.hasNext()){
            Member tempM = iter.next();
            logger.info("tempM Name : " + tempM.getMemberName());
            logger.info("tempM CreateTime : " + simpleDateFormat.format( tempM.getCreateTime()) );
        }
        return "hello moneynote";
    }

}