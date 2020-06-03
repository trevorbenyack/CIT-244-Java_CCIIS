import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class CcCustFinData extends CcCustomer{

    private String accountNum;
    private String accountType;
    private String creditLimit;
    private String prevBalance;

    // Each line item is stored in a one dimensional array with the first element as the line item description and
    // the second element as the amount (debit (-) or credit (+)). Each line item array is then added to the
    // ledgerList list
    ArrayList<String[]> ledgerList = new ArrayList<>();

    public CcCustFinData(){
    }

    @Override
    public String getAccountNum() {
        return accountNum;
    }

    @Override
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getPrevBalance() {
        return prevBalance;
    }

    public void setPrevBalance(String prevBalance) {
        this.prevBalance = prevBalance;
    }

    public ArrayList<String[]> getLedgerList() {
        return ledgerList;
    }

    public void setLedgerList(ArrayList<BigDecimal> creditsLedgerList) {
        this.ledgerList = ledgerList;
    }

    public abstract BigDecimal getLedgerListTotal();
    public abstract BigDecimal getInitialStatementBalance();
    public abstract BigDecimal getInterestCharge();
    public abstract BigDecimal getFinalStatementBalance();
    public abstract BigDecimal getNewMinPaymentAmt();
    public abstract Boolean getIsOverCreditLimit ();
    public abstract BigDecimal getRemainingCreditAmt();

}
