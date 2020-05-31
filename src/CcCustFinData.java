import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class CcCustFinData extends CcCustomer{

    private int accountNum;
    private enum accountType {Business, Personal}
    private BigDecimal creditLimit;
    private BigDecimal prevBalance;

    // Each line item is stored in a one dimensional array with the first element as the amount (debit (-) or credit (+))
    // and the second element as its description. Each line item array is then added to the ledgerList list
    ArrayList<String[]> ledgerList = new ArrayList<>();

    public CcCustFinData(){
    }

    @Override
    public int getAccountNum() {
        return accountNum;
    }

    @Override
    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getPrevBalance() {
        return prevBalance;
    }

    public void setPrevBalance(BigDecimal prevBalance) {
        this.prevBalance = prevBalance;
    }

    public ArrayList<String[]> getLedgerList() {
        return ledgerList;
    }

    public void setLedgerList(ArrayList<BigDecimal> creditsLedgerList) {
        this.ledgerList = ledgerList;
    }

    public abstract BigDecimal getLedgerTotal(ArrayList<String[]> ledgerList);
    public abstract void addToLedgerList(ArrayList<String[]> ledgerList, String creditDebit, String description);
    public abstract BigDecimal getInterestCharge(BigDecimal annualInterestRate);
    public abstract BigDecimal getFinalStatementBalance(BigDecimal overLimitFee, BigDecimal annualInterestRate);
    public abstract BigDecimal getNewMinPaymentAmt(BigDecimal paymentRate, BigDecimal finalStatementBalance);
    public abstract Boolean isOverCreditLimit(BigDecimal semiFinalBalance);

}
