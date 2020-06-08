import java.math.BigDecimal;
import java.util.ArrayList;

public class CcAccount extends CcCustomer {

    private String accountNum;
    private AccountType accountType;
    private String creditLimit;
    private String prevBalance;

    public CcAccount(){
    }

    @Override
    public String getAccountNum() {
        return accountNum;
    }

    @Override
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getPrevBalance() {
        return prevBalance;
    }

    public void setPrevBalance(String prevBalance) {
        this.prevBalance = prevBalance;
    }

}
