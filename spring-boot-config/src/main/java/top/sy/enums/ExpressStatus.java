package top.sy.enums;

public enum ExpressStatus {
    CREATED("已揽收"),
    DELIVERING("在途中"),
    DELIVERED("已签收");

    private final String label;
    ExpressStatus(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
}
