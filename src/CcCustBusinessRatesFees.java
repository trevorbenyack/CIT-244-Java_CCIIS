import java.math.BigDecimal;

public class CcCustBusinessRatesFees extends CcCustCcFinCalcs{
    private final BigDecimal ANNUAL_INTEREST_RATE = new BigDecimal(".16");
    private final BigDecimal BUSINESS_PAYMENT_RATE = new BigDecimal("0.03");
    private final BigDecimal OVER_LIMIT_FEE = new BigDecimal("20");
}
