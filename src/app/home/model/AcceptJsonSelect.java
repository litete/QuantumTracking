package app.home.model;


import java.sql.Date;

/**
 * Created by Administrator on 2017/1/4.
 */
public class AcceptJsonSelect {
    private int first_catalog;
    private int second_catalog;
    private int third_catalog;
    private int brand_id;
    private Date date1;
    private Date date2;

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }
    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public int getFirst_catalog() {
        return first_catalog;
    }

    public void setFirst_catalog(int first_catalog) {
        this.first_catalog = first_catalog;
    }

    public int getSecond_catalog() {
        return second_catalog;
    }

    public void setSecond_catalog(int second_catalog) {
        this.second_catalog = second_catalog;
    }

    public int getThird_catalog() {
        return third_catalog;
    }

    public void setThird_catalog(int third_catalog) {
        this.third_catalog = third_catalog;
    }
}
