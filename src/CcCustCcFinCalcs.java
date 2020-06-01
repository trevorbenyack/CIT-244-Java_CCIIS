import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

// Future streamlining of the program should include combining the Business & Personal CcFinData classes and then
// using an extended class for interest rate, payment rate and over-limit fee to reduce redundancy.
public class CcCustCcFinCalcs extends CcCustFinData {

    final BigDecimal ZERO_BD = new BigDecimal(0);

    public CcCustCcFinCalcs() {
    }

    // adds all Credits or Debits made to the account
    @Override
    public BigDecimal getLedgerTotal(ArrayList<String[]> ledgerList) {

        BigDecimal total = ZERO_BD;
        for(String[] lineItem : ledgerList)
        {
            BigDecimal tempTotal = total;
            total = tempTotal.add(new BigDecimal(lineItem[0]));
        }
        return total;
    }

    // returns the balance of the account before monthly interest charges and fees
    public BigDecimal getInitialStatementBalance() {

        BigDecimal prevBalance = getPrevBalance();
        BigDecimal ledgerListTotal = getLedgerTotal(getLedgerList());
        return prevBalance.add(ledgerListTotal);

    }

    // returns the interest charge on the account for the current month
    @Override
    public BigDecimal getInterestCharge(BigDecimal annualInterestRate) {

        BigDecimal initialBalance = getInitialStatementBalance();
        BigDecimal interestCharge;

        if (initialBalance.compareTo(ZERO_BD) <= 0) {
            interestCharge = ZERO_BD;
        } else {
            interestCharge = initialBalance.multiply(annualInterestRate
                    .divide(new BigDecimal(12), 3, RoundingMode.HALF_EVEN));
        }
        return interestCharge;
    }

    // returns the ending statement balance of the account for the month
    // includes interest charges and fees
    @Override
    public BigDecimal getFinalStatementBalance(BigDecimal overLimitFee, BigDecimal annualInterestRate) {

        BigDecimal initialStatementBalance = getInitialStatementBalance();
        BigDecimal semiFinalBalance = initialStatementBalance.add(getInterestCharge(annualInterestRate));

        if (isOverCreditLimit(semiFinalBalance))
        {
            return semiFinalBalance.add(overLimitFee);
        } else {
            return semiFinalBalance;
        }
    }

    @Override
    public Boolean isOverCreditLimit(BigDecimal semiFinalBalance) {

        return semiFinalBalance.compareTo(getCreditLimit()) > 0;
    }

    @Override
    public BigDecimal getNewMinPaymentAmt(BigDecimal paymentRate, BigDecimal finalStatementBalance) {
        if (finalStatementBalance.compareTo(ZERO_BD) <= 0) {
            return ZERO_BD;
        } else {
            return finalStatementBalance.multiply(paymentRate);
        }
    }
}


