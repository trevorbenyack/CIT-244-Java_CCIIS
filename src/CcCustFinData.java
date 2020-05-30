import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class CcCustFinData extends CcCustomer{

    private int routingNum;
    private int branchNum;
    private enum accountType {Business, Personal}
    private BigDecimal creditLimit;
    private BigDecimal prevBalance;

    private ArrayList<String> purchaseDescription; // each element corresponds to element in credits

    // The credit card account that a bank creates for a customer is considered a liability account
    ArrayList<BigDecimal> creditsLedgerList = new ArrayList<>(); // lending increases balance of a liability account
    ArrayList<BigDecimal> debitsLedgerList = new ArrayList<>(); // payments received decrease balance of a liability account

    public abstract BigDecimal getLedgerTotal(ArrayList<BigDecimal> ledgerList);
    public abstract void addToLedgerList(ArrayList<BigDecimal> ledgerList, String lineItem);
    public abstract BigDecimal getFinanceCharge();
    public abstract BigDecimal getFinalStatementBalance();
    public abstract BigDecimal getNewMinPaymentAmt();
    public abstract Boolean isOverCreditLimit(BigDecimal semiFinalBalance);

    public CcCustFinData(){
    }

    @Override
    public int getRoutingNum() {
        return routingNum;
    }

    @Override
    public void setRoutingNum(int routingNum) {
        this.routingNum = routingNum;
    }

    @Override
    public int getBranchNum() {
        return branchNum;
    }

    @Override
    public void setBranchNum(int branchNum) {
        this.branchNum = branchNum;
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

    // THESE WON'T BE GETTER SETTER... They'll need to be changed to add/retrieve
    public ArrayList<String> getPurchaseDescription() {
        return purchaseDescription;
    }
    public void setPurchaseDescription(ArrayList<String> purchaseDescription) {
        this.purchaseDescription = purchaseDescription;
    }

    public ArrayList<BigDecimal> getCreditsLedgerList() {
        return creditsLedgerList;
    }

    public void setCreditsLedgerList(ArrayList<BigDecimal> creditsLedgerList) {
        this.creditsLedgerList = creditsLedgerList;
    }

    public ArrayList<BigDecimal> getDebitsLedgerList() {
        return debitsLedgerList;
    }

    public void setDebitsLedgerList(ArrayList<BigDecimal> debitsLedgerList) {
        this.debitsLedgerList = debitsLedgerList;
    }


}
