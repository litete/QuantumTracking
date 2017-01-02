package app.home.model;

/**
 * Created by lite on 2017/1/1.
 */
public class ResultTjdLine {
    private String product_brand;
    private double PC;
    private double mobile;
    private String date_id;
    private double average;

    public String getProduct_brand() {
        return product_brand;
    }

    public void setProduct_brand(String product_brand) {
        this.product_brand = product_brand;
    }

    public double getPC() {
        return PC;
    }

    public void setPC(double PC) {
        this.PC = PC;
    }

    public double getMobile() {
        return mobile;
    }

    public void setMobile(double mobile) {
        this.mobile = mobile;
    }

    public String getDate_id() {
        return date_id;
    }

    public void setDate_id(String date_id) {
        this.date_id = date_id;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
