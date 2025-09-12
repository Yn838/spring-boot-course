package top.sy.enums;

public enum DrinkType {
    COFFEE("咖啡","10"),
    TEA("茶 ","50"),
    BEER("啤酒 ","20"),
    JUICE("果汁","60");

    private final String label;
    private final String price;

    private DrinkType(String label, String price) {
        this.label = label;
        this.price = price;
    }
    public String getLabel() {
        return label;
    }
    public String getPrice() {
        return price;
    }
}
