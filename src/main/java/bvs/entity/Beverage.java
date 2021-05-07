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

	public Beverage(long id, String name, String type, float price, short alcoholContent, 
			int amount) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.alcoholContent = alcoholContent;
		this.amount = amount;
		this.loss = 0;
		this.isProhibited = false;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public float getPrice() {
		return price;
	}

	public short getAlcoholContent() {
		return alcoholContent;
	}

	public int getAmount() {
		return amount;
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
