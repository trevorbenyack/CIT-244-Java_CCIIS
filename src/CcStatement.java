import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class CcStatement extends CcAccount{

    private String annualInterestRate;
    private String paymentRate;
    private String overLimitFee;
    private static final BigDecimal ZERO_BD = new BigDecimal(0);

    // Each line item is stored in a one dimensional array with the first element as the line item description and
    // the second element as the amount (debit (-) or credit (+)). Each line item array is then added to the
    // ledgerList list
    ArrayList<String[]> ledgerList = new ArrayList<>();

    public CcStatement() {
    }

    public CcStatement(RatesFees ratesFees, ArrayList<String[]> ledgerList) {
        annualInterestRate = ratesFees.getAnnualInterestRate();
        paymentRate = ratesFees.getPaymentRate();
        overLimitFee = ratesFees.getOverLimitFee();
        this.ledgerList = ledgerList;
    }

    // adds all Credits or Debits made to the account
    public BigDecimal getLedgerListTotal() {

        BigDecimal ledgerListTotalBD = null;

        for (String[] lineItem : ledgerList) {
            BigDecimal tempTotal = ledgerListTotalBD;
            ledgerListTotalBD = tempTotal.add(new BigDecimal(lineItem[1]));
        }

        return ledgerListTotalBD;
    }

    // returns the balance of the account before monthly interest charges and fees
    public BigDecimal getInitialStatementBalance() {
        BigDecimal prevBalanceBD = new BigDecimal(getPrevBalance());
        return prevBalanceBD.add(getLedgerListTotal());
    }

    // returns the interest charge on the account for the current month
    public BigDecimal getInterestCharge() {

        BigDecimal initStmtBalBD = getInitialStatementBalance();

        if (initStmtBalBD.compareTo(ZERO_BD) <= 0) {
            return ZERO_BD;
        } else {
            return initStmtBalBD.multiply(new BigDecimal(annualInterestRate)
                    .divide(new BigDecimal(12), 3, RoundingMode.HALF_EVEN));
        }
    }

    // returns the ending statement balance of the account for the month
    // includes interest charges and fees
    public BigDecimal getFinalStatementBalance() {
        BigDecimal initStmntBalBD = getInitialStatementBalance();
        BigDecimal semiFinBalBD = initStmntBalBD.add(getInterestCharge());

        Boolean isOverCreditLimit = semiFinBalBD.compareTo(new BigDecimal(getCreditLimit())) > 0;

        if (isOverCreditLimit) {
            return semiFinBalBD.add(new BigDecimal(overLimitFee));
        } else {
            return semiFinBalBD;
        }
    }

    public BigDecimal getNewMinPaymentAmt() {

        BigDecimal finStmntBalBD = getFinalStatementBalance();

        if (finStmntBalBD.compareTo(ZERO_BD) <= 0) {
            return ZERO_BD;
        } else {
            return finStmntBalBD.multiply(new BigDecimal(paymentRate));
        }
    }

    public BigDecimal getRemainingCreditAmt() {
        BigDecimal creditLimitBD = new BigDecimal(getCreditLimit());
        return creditLimitBD.subtract(getFinalStatementBalance());

    }

}
