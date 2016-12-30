package app.home.model;

/**
 * Created by Administrator on 2016/12/30.
 */
public class LittleTjdShopIndex {
    private String product_brand;
    private String device_type;
    private double focus_index;
    private double purchase_index;
    private String date_id;

    @Override
    public String toString() {
        return "LittleTjdShopIndex{" +
                "product_brand='" + product_brand + '\'' +
                ", device_type='" + device_type + '\'' +
                ", focus_index=" + focus_index +
                ", purchase_index=" + purchase_index +
                ", date_id='" + date_id + '\'' +
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

    public String getDate_id() {
        return date_id;
    }

    public void setDate_id(String date_id) {
        this.date_id = date_id;
    }
}
