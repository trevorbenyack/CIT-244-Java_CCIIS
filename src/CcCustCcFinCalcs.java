import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

// Future streamlining of the program should include combining the Business & Personal CcFinData classes and then
// using an extended class for interest rate, payment rate and over-limit fee to reduce redundancy.
public class CcCustCcFinCalcs extends CcCustFinData {

    public CcCustCcFinCalcs() {

    }

    final BigDecimal ZERO_BD = new BigDecimal(0);
    BigDecimal ledgerListTotal = ZERO_BD;
    BigDecimal initialStatementBalance = null;
    BigDecimal interestCharge = null;
    BigDecimal finalStatementBalance = null;
    BigDecimal newMinPaymentAmt = null;
    boolean isOverCreditLimit;
    BigDecimal remainingCreditAmt = null;
    String annualInterestRate = null;
    String paymentRate = null;
    String overLimitFee = null;

    ArrayList<String[]> ledgerList;

    public CcCustCcFinCalcs(CcCustBusinessRatesFees busRatesFees,
                            ArrayList<String[]> ledgerList) {
        annualInterestRate = busRatesFees.getANNUAL_INTEREST_RATE();
        paymentRate = busRatesFees.getPAYMENT_RATE();
        overLimitFee = busRatesFees.getOVER_LIMIT_FEE();
        this.ledgerList = ledgerList;
    }

    public CcCustCcFinCalcs(CcCustPersonalRatesFees custRatesFees,
                            ArrayList<String[]> ledgerList) {
        annualInterestRate = custRatesFees.getANNUAL_INTEREST_RATE();
        paymentRate = custRatesFees.getPAYMENT_RATE();
        overLimitFee = custRatesFees.getOVER_LIMIT_FEE();
        this.ledgerList = ledgerList;
    }

    public void runCalcs() {
        calcLedgerListTotal();
        calcInitialStatementBalance();
        calcInterestCharge();
        calcFinalStatementBalance();
        calcNewMinPaymentAmt();
        calcRemainingCreditAmt();
    }


    // adds all Credits or Debits made to the account
    private void calcLedgerListTotal() {

        for(String[] lineItem : ledgerList)
        {
            BigDecimal tempTotal = ledgerListTotal;
            ledgerListTotal = tempTotal.add(new BigDecimal(lineItem[1]));
        }
    }
    @Override
    public BigDecimal getLedgerListTotal() {
        return ledgerListTotal;
    }

    // returns the balance of the account before monthly interest charges and fees
    private void calcInitialStatementBalance() {
        BigDecimal prevBalance = new BigDecimal(getPrevBalance());
        initialStatementBalance = prevBalance.add(ledgerListTotal);
    }
    @Override
    public BigDecimal getInitialStatementBalance() {
        return initialStatementBalance;
    }

    // returns the interest charge on the account for the current month
    private void calcInterestCharge() {

        if (initialStatementBalance.compareTo(ZERO_BD) <= 0) {
            interestCharge = ZERO_BD;
        } else {
            interestCharge = initialStatementBalance.multiply(new BigDecimal(annualInterestRate)
                    .divide(new BigDecimal(12), 3, RoundingMode.HALF_EVEN));
        }
    }
    @Override
    public BigDecimal getInterestCharge() {
        return interestCharge;
    }

    // returns the ending statement balance of the account for the month
    // includes interest charges and fees
    private void calcFinalStatementBalance() {

        BigDecimal semiFinalBalance = initialStatementBalance.add(interestCharge);
        isOverCreditLimit = semiFinalBalance.compareTo(new BigDecimal(getCreditLimit())) > 0;

        if (isOverCreditLimit)
        {
            finalStatementBalance = semiFinalBalance.add(new BigDecimal(overLimitFee));
        } else {
            finalStatementBalance = semiFinalBalance;
        }
    }
    @Override
    public BigDecimal getFinalStatementBalance() {
        return finalStatementBalance;
    }

    private void calcNewMinPaymentAmt() {
        if (finalStatementBalance.compareTo(ZERO_BD) <= 0) {
            newMinPaymentAmt = ZERO_BD;
        } else {
            newMinPaymentAmt = finalStatementBalance.multiply(new BigDecimal(paymentRate));
        }
    }
    @Override
    public BigDecimal getNewMinPaymentAmt(){
        return newMinPaymentAmt;
    }

    @Override
    public Boolean getIsOverCreditLimit (){
        return isOverCreditLimit;
    }

    private void calcRemainingCreditAmt() {
        BigDecimal creditLimitBD = new BigDecimal(getCreditLimit());
        remainingCreditAmt = creditLimitBD.subtract(finalStatementBalance);

    }
    @Override
    public BigDecimal getRemainingCreditAmt(){
        return remainingCreditAmt;
    };
}


