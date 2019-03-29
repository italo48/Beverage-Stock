package bvs.controle;

import java.util.List;

import bvs.entity.Beverage;

public class BeverageControl {
	private InMemoryDB db;

	public BeverageControl(InMemoryDB datab) {
		this.db = datab;
		this.setUP();
	}
	
	public boolean addBeverage(Beverage bev) {
		if (!beverageIsValid(bev)) {
			return false;
		}
		if(this.db.getDb().indexOf(bev) != -1) {
			return false;
		}
		return db.getDb().add(bev);
	}
	
	public List<Beverage> listBeverage() {
		return db.getDb();
	}
	
	public boolean delBeverage(long id) {
		Object a = findBeverage(id);
		return db.getDb().remove(a);
	}
	
	public Beverage findBeverage(long id) {
		if(id < 0) {
			return null;
		}
		for(Beverage b : db.getDb()) {
			if(b.getId() == id) {
				return b;
			}
		}
		return null;
	}
	public Beverage upBeverage(long id, Beverage bev) {
		if(!beverageIsValid(bev)) {
			return null;
		}
		
		int indexOldBev = db.getDb().indexOf(findBeverage(id));
		db.getDb().set(indexOldBev, bev);
		
		return db.getDb().get(indexOldBev);
	}
	
	private boolean beverageIsValid(Beverage bev) {
		if (bev.getId() <=  0 || bev.getAmount() < 0 || bev.getAlcoholContent() < 0
				|| bev.getLoss() > bev.getAmount() || bev.getName().equals("") 
				|| bev.getType().equals("") || bev.getPrice() == 0.0) {
			return false;
		}
		return true;
	}
	
	public Beverage toBeverage(String beverage) {
		String a[] = beverage.split(",");
		long id = Integer.parseInt(a[0]);
		float price = Float.parseFloat(a[3]);
		int ac = Integer.parseInt(a[4]);
		int qtd = Integer.parseInt(a[5]);
		
		Beverage bev = new Beverage(id, a[1], a[2], price, (short)ac, qtd);
		if(beverageIsValid(bev)) {
			return bev;
		}
		return null;
	}
	
	private void setUP() {
		this.addBeverage(new Beverage(1, "Itaipava", "Cerveja", 1.39f, (short)2, 50000));
		this.addBeverage(new Beverage(2, "Ypioca Prata", "Cachaça", 4.79f, (short)30, 5000));
		Beverage absinto = new Beverage(3, "Green Demon", "Absinto", 150.50f, (short)72, 50);
		absinto.setProhibited(true);
		this.addBeverage(absinto);
	}
}
