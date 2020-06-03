import java.math.BigDecimal;

public class CcCustBusinessRatesFees extends CcCustCcFinCalcs{
    private static final String ANNUAL_INTEREST_RATE = ".16";
    private static final String PAYMENT_RATE = "0.03";
    private static final String OVER_LIMIT_FEE = "20";

    public static String getANNUAL_INTEREST_RATE() {
        return ANNUAL_INTEREST_RATE;
    }

    public static String getPAYMENT_RATE() {
        return PAYMENT_RATE;
    }

    public static String getOVER_LIMIT_FEE() {
        return OVER_LIMIT_FEE;
    }
}
