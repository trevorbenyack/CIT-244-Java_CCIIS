import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class CcCustFinData extends CcCustomer{

    private int routingNum;
    private int branchNum;
    private enum accountType {Business, Personal}
    private BigDecimal creditLimit;
    private BigDecimal prevBalance;

    // list of purchases since last statement transaction ID, payee, date
    private ArrayList<ArrayList<String>> purchases;

    // The credit card account a bank holds for a customer is considered a liability account
    ArrayList<BigDecimal> credits; // lending increase balance
    ArrayList<BigDecimal> debits; // payments received decrease balance

    public abstract BigDecimal FinanceCharge();
    public abstract BigDecimal newBalance();
    public abstract BigDecimal newPaymentAmt();
    public abstract BigDecimal creditLimitCheck();

    public CcCustFinData(){
    }

    // account routing number or banking branch number will have to be set by overriding

}
