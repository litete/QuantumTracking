package app.home.model;

import java.sql.Date;

/**
 * Created by Administrator on 2017/1/4.
 */
public class BrandIndex {
    private int brand_id;
    private String brand_name;
    private double focus_index;
    private double purchase_index;
    private double polularity_index;
    private int device_type;
    private Date date;

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
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

    public double getPolularity_index() {
        return polularity_index;
    }

    public void setPolularity_index(double polularity_index) {
        this.polularity_index = polularity_index;
    }

    public int getDevice_type() {
        return device_type;
    }

    public void setDevice_type(int device_type) {
        this.device_type = device_type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
