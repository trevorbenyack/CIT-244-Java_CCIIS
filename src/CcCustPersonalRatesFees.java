public class CcCustPersonalRatesFees extends CcCustCcFinCalcs{
    private static final String ANNUAL_INTEREST_RATE = ".13";
    private static final String PAYMENT_RATE = "0.02";
    private static String OVER_LIMIT_FEE = "10";

    public static String getANNUAL_INTEREST_RATE() {
        return ANNUAL_INTEREST_RATE;
    }

    public static String getPAYMENT_RATE()
    {
        return PAYMENT_RATE;
    }

    public static String getOVER_LIMIT_FEE() {
        return OVER_LIMIT_FEE;
    }
}
