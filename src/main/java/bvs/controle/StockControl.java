package bvs.controle;

import bvs.entity.Beverage;

public class StockControl{
	
	private InMemoryDB bank;
	
	public StockControl(InMemoryDB db) {
		this.bank = db;
	}
	public float CalculateStock() {
		float sum = 0;
		for (Beverage bebida : bank.getDb()) {
			sum += bebida.getPrice();
			
		}return sum;
	}
	public byte LevelStock() {
		byte sum = 0;
		for (Beverage bebida : bank.getDb()) {
			sum += bebida.getAmount();
			sum -=bebida.getLoss();
		}
		if (sum > 100) {
			//System.out.println("cheio");
			return 100;
		}
		if (sum > 50) {
			//System.out.println("metade");
			return sum;
		}else {
			//System.out.println("vazio");
			return sum;
		}
			
	}
	public short LevelBeverage(int id) {
		double total = LevelStock();
		double result = 0;
		for (Beverage bebida : bank.getDb()) {
			if (bebida.getId() == id) {
				result = ((bebida.getAmount() - bebida.getLoss())/total) * 100;
			}
		}
		return (short) result;
	}
	public double ValueStockLoss() {
		int sum = 0;
		for (Beverage bebida : bank.getDb()) {
			sum +=bebida.getLoss();
		}
		return sum;
	}
	
}