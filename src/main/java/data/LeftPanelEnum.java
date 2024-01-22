package data;

public enum LeftPanelEnum {
    OPEN_NEW_ACCOUNT("Open New Account"),
    ACCOUNTS_OVERVIEW("Accounts Overview"),
    TRANSFER_FUNDS("Transfer Funds"),
    BILL_PAY("Bill Pay"),
    FIND_TRANSACTIONS("Find Transactions"),
    UPDATE_CONTACT_INFO("Update Contact Info"),
    REQUEST_LOAN("Request Loan"),
    LOG_OUT("Log out");

    private final String leftPanelOptions;

    LeftPanelEnum(String leftPanelOptions) {
        this.leftPanelOptions = leftPanelOptions;
    }

    @Override
    public String toString() {
        return leftPanelOptions;
    }
}
