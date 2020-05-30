import java.math.BigDecimal;
import java.util.ArrayList;

public class scratch {

    public static void main(String[] args) {
        CcCustFinData test = new CcCustBusCcFinData();
        for (int i = 0; i < 5; i++) {
            Integer integer = i;
            test.addToLedgerList(test.getCreditsLedgerList(), integer.toString());
        }

        System.out.println(test.getCreditsLedgerList());
        System.out.println(test.getLedgerTotal(test.getCreditsLedgerList()));
    }
}
