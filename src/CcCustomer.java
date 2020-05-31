public class CcCustomer extends CcCompany {
    private int routingNum;
    private int branchNum;

    private int customerAcctNum;
    private String customerName;
    private String customerAddress;
    private String customerCity;
    private String customerState;
    private String customerZip;
    private String customerEmail;
    private int customerPhone;

    public CcCustomer() {
    }

    @Override
    public int getRoutingNum() {
        return routingNum;
    }

    @Override
    public void setRoutingNum(int routingNum) {
        this.routingNum = routingNum;
    }

    @Override
    public int getBranchNum() {
        return branchNum;
    }

    @Override
    public void setBranchNum(int branchNum) {
        this.branchNum = branchNum;
    }

    public int getAccountNum() {
        return customerAcctNum;
    }

    public void setAccountNum(int accountNum) {
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

    public int getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }
}
