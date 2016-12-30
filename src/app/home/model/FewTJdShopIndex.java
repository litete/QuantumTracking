package app.home.model;

/**
 * Created by lite on 2016/12/29.
 */
public class FewTJdShopIndex {
    private String product_brand;
    private String device_type;
    private double focus_index;
    private double purchase_index;

    @Override
    public String toString() {
        return "FewTJdShopIndex{" +
                "product_brand='" + product_brand + '\'' +
                ", device_type='" + device_type + '\'' +
                ", focus_index=" + focus_index +
                ", purchase_index=" + purchase_index +
                '}';
    }

    public String getProduct_brand() {
        return product_brand;
    }

    public void setProduct_brand(String product_brand) {
        this.product_brand = product_brand;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public double getFocus_index() {
        return focus_index;
    }

    public void setFocus_index(double focus_index) {
        this.focus_index = focus_index;
    }

    public double getPurchase_index() {
        return purchase_index;
    }

    public void setPurchase_index(double purchase_index) {
        this.purchase_index = purchase_index;
    }
}
