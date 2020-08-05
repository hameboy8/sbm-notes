package tw.sian.notes.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tw.sian.notes.NotesApplication;
import tw.sian.notes.model.ExpenseRecord;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { NotesApplication.class })
public class ExpenseRecordMapperTest {
    BigInteger memberId = new BigInteger("42");
    static List<String> logList = new ArrayList<String>();
    static BigInteger newInsertExpenseId;

    ExpenseRecordMapper expenseRecordMapper;
    @Autowired
    public void setExpenseRecordMapper(ExpenseRecordMapper expenseRecordMapper){
        this.expenseRecordMapper = expenseRecordMapper;
    }
    @Test
    public void selectListByMemberIdTest(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        List<ExpenseRecord> list = expenseRecordMapper.selectListByMemberId( memberId );
        Iterator<ExpenseRecord> iter = list.iterator();
        while (iter.hasNext()){
            ExpenseRecord temp = iter.next();
            System.out.println("temp Item : " + temp.getExpenseItem());
            System.out.println("tempM CreateTime : " + simpleDateFormat.format( temp.getCreateTime()) );
        }
        Iterator<String> logIter = logList.iterator();
        while (logIter.hasNext()){
            String temp = logIter.next();
            System.out.println(temp);
        }
    }
    @Test
    public void insertTest(){
        Date today = new Date();
        ExpenseRecord expenseRecord = new ExpenseRecord();
        expenseRecord.setMemberId(memberId);
        expenseRecord.setExpenseItem("晚餐I");
        expenseRecord.setExpenseAmount(new BigInteger("333"));
        expenseRecord.setExpenseDate(today);
        expenseRecord.setCreateTime(today);
        expenseRecord.setUpdateTime(today);
        expenseRecordMapper.insert(expenseRecord);

        newInsertExpenseId = expenseRecord.getExpenseId();
        System.out.println("newInsertExpenseId : " + newInsertExpenseId);
    }

    @Test
    public void updateTest(){
        Date today = new Date();
        ExpenseRecord expenseRecord = new ExpenseRecord();
        expenseRecord.setExpenseId(newInsertExpenseId);
        expenseRecord.setExpenseItem("晚餐U");
        expenseRecord.setExpenseAmount(new BigInteger("33322"));
        expenseRecord.setExpenseDate(today);
        expenseRecord.setUpdateTime(today);
        expenseRecordMapper.update(expenseRecord);
    }

    @Test
    public void deleteByExpenseIdTest(){
        System.out.println("newInsertExpenseId : " + newInsertExpenseId);
        expenseRecordMapper.deleteByExpenseId(newInsertExpenseId);
    }
}
