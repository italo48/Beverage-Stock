package bvs.controle;

import java.util.List;

import bvs.entity.Beverage;

public class BeverageControl {
	private InMemoryDB db;

	public BeverageControl(InMemoryDB datab) {
		this.db = datab;
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
}
