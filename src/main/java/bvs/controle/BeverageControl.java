package bvs.controle;

import java.util.List;

import bvs.entity.Beverage;

public class BeverageControl {
	private InMemoryDB db;

	public BeverageControl(InMemoryDB b) {
		this.db = b;
	}
	
	public boolean addBeverage(Beverage b) {
		if (b.getId() <=  0 || b.getAmount() < 0 || b.getAlcoholContent() < 0) {
			return false;
		}
		if(this.db.getDb().indexOf(b) != -1) {
			return false;
		}
		return db.getDb().add(b);
	}
	
	public List<Beverage> listBeverage() {
		return db.getDb();
	}
	
	public boolean delBeverage(long id) {
		Object a = findBeverage(id);
		return db.getDb().remove(a);
	}
	
	public Beverage findBeverage(long id) {
		if(!idIsValid(id)) {
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
		if(!idIsValid(id)) {
			return null;
		}
		
		int indexOldBev = db.getDb().indexOf(findBeverage(id));
		db.getDb().set(indexOldBev, bev);
		
		return db.getDb().get(indexOldBev);
	}
	
	private boolean idIsValid(long id) {
		return id > 0 ? true : false; 
	}
}
