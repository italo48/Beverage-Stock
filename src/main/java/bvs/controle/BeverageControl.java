package bvs.controle;

import java.util.List;

import bvs.entity.Beverage;

public class BeverageControl {
	private InMemoryDB db;

	public BeverageControl(InMemoryDB b) {
		this.db = b;
	}
	
	public boolean addBeverage(Beverage b) {
		if (b.getId() <=  0) {
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
}
