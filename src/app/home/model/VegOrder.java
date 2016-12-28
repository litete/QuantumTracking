package app.home.model;

import java.sql.Timestamp;

public class VegOrder {
	private Integer id;
	private String ordernum;
	private String ordertime;
	private String vegname;
	private Integer vegnum;
	private String vegprice;
	private String vegallprice;
	private String shouname;
	private String shounumber;
	private String shouaddress;
	private String buy_zhuangtai;
	private String buy_ip;
	private String buy_user;
	private String buy_way;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public String getVegname() {
		return vegname;
	}

	public void setVegname(String vegname) {
		this.vegname = vegname;
	}

	public Integer getVegnum() {
		return vegnum;
	}

	public void setVegnum(Integer vegnum) {
		this.vegnum = vegnum;
	}

	public String getVegprice() {
		return vegprice;
	}

	public void setVegprice(String vegprice) {
		this.vegprice = vegprice;
	}

	public String getVegallprice() {
		return vegallprice;
	}

	public void setVegallprice(String vegallprice) {
		this.vegallprice = vegallprice;
	}

	public String getShouname() {
		return shouname;
	}

	public void setShouname(String shouname) {
		this.shouname = shouname;
	}

	public String getShounumber() {
		return shounumber;
	}

	public void setShounumber(String shounumber) {
		this.shounumber = shounumber;
	}

	public String getShouaddress() {
		return shouaddress;
	}

	public void setShouaddress(String shouaddress) {
		this.shouaddress = shouaddress;
	}

	public String getBuy_zhuangtai() {
		return buy_zhuangtai;
	}

	public void setBuy_zhuangtai(String buy_zhuangtai) {
		this.buy_zhuangtai = buy_zhuangtai;
	}
	
	public String getBuy_ip() {
		return buy_ip;
	}

	public void setBuy_ip(String buy_ip) {
		this.buy_ip = buy_ip;
	}

	public String getBuy_user() {
		return buy_user;
	}

	public void setBuy_user(String buy_user) {
		this.buy_user = buy_user;
	}

	public String getBuy_way() {
		return buy_way;
	}

	public void setBuy_way(String buy_way) {
		this.buy_way = buy_way;
	}
}
