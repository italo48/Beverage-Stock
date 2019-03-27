package bvs.entity;

public class Beverage {
	private long id;
	private String name;
	private String type;
	private float price;
	private short alcoholContent;
	private int amount;
	private int loss;
	private boolean isProhibited;
	
	public Beverage() {
	}

	public Beverage(long id, String name, String type, float price, short alcoholContent, int amount,
			int loss, boolean isProhibited) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.alcoholContent = alcoholContent;
		this.amount = amount;
		this.loss = loss;
		this.isProhibited = isProhibited;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public short getAlcoholContent() {
		return alcoholContent;
	}

	public void setAlcoholContent(short alcoholContent) {
		this.alcoholContent = alcoholContent;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isProhibited() {
		return isProhibited;
	}

	public void setProhibited(boolean isProhibited) {
		this.isProhibited = isProhibited;
	}

	public int getLoss() {
		return loss;
	}

	public void setLoss(int perdas) {
		this.loss = perdas;
	}
}
