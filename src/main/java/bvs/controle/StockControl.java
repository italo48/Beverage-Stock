package bvs.controle;

import bvs.dao.BeverageDAO;
import bvs.entity.Beverage;

public class StockControl{
	private BeverageDAO bank;
	public StockControl(BeverageDAO db) {
		this.bank = db;
	}
	public float CalculateStock() {
		float sum = 0;
		for (Beverage bebida : bank.listAllBeverage()) {
			sum += bebida.getPrice();
			
		}return sum;
	}
	public int total() {
		int sum = 0;
		for (Beverage bebida : bank.listAllBeverage()) {
			sum += bebida.getAmount();
			sum -=bebida.getLoss();
		}
		return sum;
	}
	public double calcPorc() {
		return (total() * 100)/1500;
	}
	public byte LevelStock() {
		double qtd = total();
		byte percent = (byte) calcPorc();
		if (qtd > 1500) {
			//System.out.println("cheio");
			return 100;
		}else {
			//System.out.println("vazio");
			return percent;
		}
			
	}
	public short LevelBeverage(int id) {
		double total = total();
		double result = 0;
		for (Beverage bebida : bank.listAllBeverage()) {
			if (bebida.getId() == id) {
				result = ((bebida.getAmount() - bebida.getLoss()) * 100)/total;
			}
		}
		return (short) result;
	}
	public double ValueStockLoss() {
		int sum = 0;
		for (Beverage bebida : bank.listAllBeverage()) {
			sum +=bebida.getLoss();
		}
		return sum;
	}
	public boolean RegLoss(long id, int qtdLost) {
		for (Beverage bebida : bank.listAllBeverage()) {
			if (bebida.getId() == id) {
				if (bebida.getAmount() > qtdLost) {
					bebida.setLoss(qtdLost);
					return true;
				}
			}
		}return false;
	}
	
}