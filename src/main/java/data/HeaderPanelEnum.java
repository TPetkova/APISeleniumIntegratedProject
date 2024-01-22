package data;

public enum HeaderPanelEnum {

    SOLUTIONS("Solutions"),
    ABOUT_US("About us"),
    SERVICES("Services"),
    PRODUCTS("Products"),
    LOCATIONS("Locations"),
    ADMIN_PAGE("Admin Page"),
    HOME("home"),
    ABOUT("about"),
    CONTACT("contact");

    private final String headerPanelOptions;

    HeaderPanelEnum(String headerPanelOptions) {
        this.headerPanelOptions = headerPanelOptions;
    }

    @Override
    public String toString() {
        return headerPanelOptions;
    }

}
