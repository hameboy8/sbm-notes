package tw.sian.notes.model;

import java.math.BigInteger;
import java.util.Date;

public class ExpenseRecord {
    private BigInteger expenseId;
    private BigInteger memberId;
    private String expenseItem;
    private BigInteger expenseAmount;
    private Date expenseDate;
    private Date createTime;
    private Date updateTime;

    public BigInteger getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(BigInteger expenseId) {
        this.expenseId = expenseId;
    }

    public BigInteger getMemberId() {
        return memberId;
    }

    public void setMemberId(BigInteger memberId) {
        this.memberId = memberId;
    }

    public String getExpenseItem() {
        return expenseItem;
    }

    public void setExpenseItem(String expenseItem) {
        this.expenseItem = expenseItem;
    }

    public BigInteger getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(BigInteger expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
