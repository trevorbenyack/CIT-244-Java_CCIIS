public class RatesFees {
    private String annualInterestRate;
    private String paymentRate;
    private String overLimitFee;

    public RatesFees() {
    }

    public RatesFees(AccountType accountType) {
        if (accountType == AccountType.BUSINESS) {
            annualInterestRate = RatesFees_Business.ANNUAL_INTEREST_RATE;
            paymentRate = RatesFees_Business.PAYMENT_RATE;
            overLimitFee = RatesFees_Business.OVER_LIMIT_FEE;
        } else if (accountType == AccountType.PERSONAL) {
            annualInterestRate = RatesFees_Personal.ANNUAL_INTEREST_RATE;
            paymentRate = RatesFees_Personal.PAYMENT_RATE;
            overLimitFee = RatesFees_Personal.OVER_LIMIT_FEE;
        }
    }

    public String getAnnualInterestRate() {
        return annualInterestRate;
    }

    public String getPaymentRate() {
        return paymentRate;
    }

    public String getOverLimitFee() {
        return overLimitFee;
    }
}
