package app.home.model;

/**
 * Created by lite on 2016/12/28.
 */
public class TJdShopIndex {
    private String first_catalog;
    private String second_catalog;
    private String third_catalog;
    private String product_brand;
    private int  goods_num;
    private String date_id;
    private String device_type;
    private double pv;
    private double focus_index;

    @Override
    public String toString() {
        return "TJdShopIndex{" +
                "first_catalog='" + first_catalog + '\'' +
                ", second_catalog='" + second_catalog + '\'' +
                ", third_catalog='" + third_catalog + '\'' +
                ", product_brand='" + product_brand + '\'' +
                ", goods_num=" + goods_num +
                ", date_id='" + date_id + '\'' +
                ", device_type='" + device_type + '\'' +
                ", pv=" + pv +
                ", focus_index=" + focus_index +
                '}';
    }

    public String getFirst_catalog() {
        return first_catalog;
    }

    public void setFirst_catalog(String first_catalog) {
        this.first_catalog = first_catalog;
    }

    public String getSecond_catalog() {
        return second_catalog;
    }

    public void setSecond_catalog(String second_catalog) {
        this.second_catalog = second_catalog;
    }

    public String getThird_catalog() {
        return third_catalog;
    }

    public void setThird_catalog(String third_catalog) {
        this.third_catalog = third_catalog;
    }

    public String getProduct_brand() {
        return product_brand;
    }

    public void setProduct_brand(String product_brand) {
        this.product_brand = product_brand;
    }

    public int getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(int goods_num) {
        this.goods_num = goods_num;
    }

    public String getDate_id() {
        return date_id;
    }

    public void setDate_id(String date_id) {
        this.date_id = date_id;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public double getPv() {
        return pv;
    }

    public void setPv(double pv) {
        this.pv = pv;
    }

    public double getFocus_index() {
        return focus_index;
    }

    public void setFocus_index(double focus_index) {
        this.focus_index = focus_index;
    }
}
