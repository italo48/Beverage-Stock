package bvs.controle;

import java.util.List;

import bvs.dao.BeverageDAO;
import bvs.entity.Beverage;

public class BeverageControl {

	private StockControl stock;
	private BeverageDAO beveDAO;

	public BeverageControl(BeverageDAO datab, StockControl stock) {
		this.beveDAO = datab;
		this.stock = stock;
	}
	
	public boolean addBeverage(Beverage bev) {
		if (!beverageIsValid(bev)) {
			return false;
		}
		if (bev.getAmount() + stock.total() > 1500) {
			return false;
		}
		if (this.beveDAO.listAllBeverage().indexOf(bev) != -1) {
			return false;
		}
		beveDAO.addBeverage(bev);
		return true;
	}
	
	public List<Beverage> listBeverage() {
		return beveDAO.listAllBeverage();
	}
	
	public boolean delBeverage(long id) {
		beveDAO.removeBeverage(findBeverage(id));
		return true;
	}
	
	public Beverage findBeverage(long id) {
		if(id < 0) {
			return null;
		}
		for(Beverage b : beveDAO.listAllBeverage()) {
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
		return beveDAO.alterBerverage(bev);
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
	public Beverage toBeverage(String beverage) throws Exception {
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
