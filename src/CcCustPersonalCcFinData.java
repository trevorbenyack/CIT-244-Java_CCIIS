import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

// Future streamlining of the program should include combining the Business & Personal CcFinData classes and then
// using an extended class for interest rate, payment rate and over-limit fee to reduce redundancy.
public class CcCustPersonalCcFinData extends CcCustFinData {

    private final BigDecimal ANNUAL_INTEREST_RATE = new BigDecimal(".13");
    private final BigDecimal BUSINESS_PAYMENT_RATE = new BigDecimal("0.02");
    private final BigDecimal OVER_LIMIT_FEE = new BigDecimal("10");
    private final BigDecimal ZERO_BD = new BigDecimal(0);

    public CcCustPersonalCcFinData() {
    }

    // adds all Credits or Debits made to the account
    @Override
    public BigDecimal getLedgerTotal(ArrayList<BigDecimal> ledgerList) {

        BigDecimal total = ZERO_BD;
        for(BigDecimal lineItem : ledgerList)
        {
            BigDecimal tempTotal = total;
            total = tempTotal.add(lineItem);
        }
        return total;
    }

    // adds a single credit or debit to it's respective ledger
    public void addToLedgerList(ArrayList<BigDecimal> ledgerList, String lineItem) {
        ledgerList.add(new BigDecimal(lineItem));
    }

    // returns the balance of the account before monthly interest charges and fees
    public BigDecimal getInitialStatementBalance() {

        BigDecimal prevBalance = getPrevBalance();
        BigDecimal creditsTotal = getLedgerTotal(getCreditsLedgerList());
        BigDecimal debitsTotal = getLedgerTotal(getDebitsLedgerList());
        return prevBalance.add(creditsTotal).subtract(debitsTotal);

    }

    // returns the interest charge on the account for the current month
    @Override
    public BigDecimal getFinanceCharge() {

        BigDecimal initialBalance = getInitialStatementBalance();
        BigDecimal financeCharge;

        if (initialBalance.compareTo(ZERO_BD) <= 0) {
            financeCharge = ZERO_BD;
        } else {
            financeCharge = initialBalance.multiply(ANNUAL_INTEREST_RATE.divide(new BigDecimal(12), 3, RoundingMode.HALF_EVEN));
        }
        return financeCharge;
    }

    // returns the ending statement balance of the account for the month
    // includes interest charges and fees
    @Override
    public BigDecimal getFinalStatementBalance() {

        BigDecimal initialStatementBalance = getInitialStatementBalance();
        BigDecimal semiFinalBalance = initialStatementBalance.add(getFinanceCharge());

        if (isOverCreditLimit(semiFinalBalance))
        {
            return semiFinalBalance.add(OVER_LIMIT_FEE);
        } else {
            return semiFinalBalance;
        }
    }

    @Override
    public Boolean isOverCreditLimit(BigDecimal semiFinalBalance) {

        return semiFinalBalance.compareTo(getCreditLimit()) > 0;
    }

    @Override
    public BigDecimal getNewMinPaymentAmt() {
        if (getFinalStatementBalance().compareTo(ZERO_BD) <= 0) {
            return ZERO_BD;
        } else {
            return getFinalStatementBalance().multiply(BUSINESS_PAYMENT_RATE);
        }
    }
}


