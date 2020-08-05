package tw.sian.notes.mapper;

import org.apache.ibatis.annotations.Mapper;
import tw.sian.notes.model.ExpenseRecord;

import java.math.BigInteger;
import java.util.List;

public interface ExpenseRecordMapper {
    List<ExpenseRecord> selectListByMemberId(BigInteger memberId);

    void insert(ExpenseRecord expenseRecord);

    void update(ExpenseRecord expenseRecord);

    void deleteByExpenseId(BigInteger expenseId);
}
