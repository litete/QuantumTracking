package app.home.model;

public class Cook {

	private int id;
	private String cook_name;
	private String info;
	private String from_gs;
	private float price;
	private String img;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCook_name() {
		return cook_name;
	}

	public void setCook_name(String cook_name) {
		this.cook_name = cook_name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getFrom_gs() {
		return from_gs;
	}

	public void setFrom_gs(String from_gs) {
		this.from_gs = from_gs;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
