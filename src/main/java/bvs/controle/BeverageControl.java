package bvs.controle;

import java.util.List;

import bvs.entity.Beverage;

public class BeverageControl {
	private InMemoryDB db;
	private StockControl stock;

	public BeverageControl(InMemoryDB datab, StockControl stock) {
		this.db = datab;
		this.stock = stock;
	}
	
	public boolean addBeverage(Beverage bev) {
		if (!beverageIsValid(bev)) {
			return false;
		}
		if (bev.getPrice() + stock.total() > 1500) {
			return false;
		}
		if (this.db.getDb().indexOf(bev) != -1) {
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
//	Ganbs
	public Beverage toBeverage(String beverage) {
		String bevStringFormat[] = beverage.split(",");
		long id = Integer.parseInt(bevStringFormat[0]);
		float price = Float.parseFloat(bevStringFormat[3]);
		int ac = Integer.parseInt(bevStringFormat[4]);
		int qtd = Integer.parseInt(bevStringFormat[5]);
		
		Beverage bev = new Beverage(id, bevStringFormat[1], bevStringFormat[2], price, (short)ac, qtd);
		if(beverageIsValid(bev)) {
			return bev;
		}
		return null;
	}
}
