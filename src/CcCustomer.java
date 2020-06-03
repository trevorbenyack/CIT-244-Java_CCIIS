public class CcCustomer extends CcCompany {
    private String routingNum;
    private String branchNum;

    private String customerAcctNum;
    private String customerName;
    private String customerAddress;
    private String customerCity;
    private String customerState;
    private String customerZip;
    private String customerEmail;
    private String customerPhone;

    public CcCustomer() {
    }

    @Override
    public String getRoutingNum() {
        return routingNum;
    }

    @Override
    public void setRoutingNum(String routingNum) {
        this.routingNum = routingNum;
    }

    @Override
    public String getBranchNum() {
        return branchNum;
    }

    @Override
    public void setBranchNum(String branchNum) {
        this.branchNum = branchNum;
    }

    public String getAccountNum() {
        return customerAcctNum;
    }

    public void setAccountNum(String accountNum) {
        this.customerAcctNum = accountNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerZip() {
        return customerZip;
    }

    public void setCustomerZip(String customerZip) { this.customerZip = customerZip; }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
