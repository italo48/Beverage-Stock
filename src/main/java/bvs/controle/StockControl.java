package bvs.controle;

import bvs.entity.Beverage;

public class StockControl{
	
	private InMemoryDB b;
	
	public StockControl(InMemoryDB db) {
		this.b = db;
	}
	public float CalculateStock() {
		float sum = 0;
		for (Beverage h : b.getDb()) {
			sum += h.getPreco();
			
		}return sum;
	}
	public byte LevelStock() {
		byte sum = 0;
		for (Beverage h : b.getDb()) {
			sum += h.getQtd();
			
		}
		if (sum > 100) {
			System.out.println("cheio");
			return 100;
		}
		if (sum > 50) {
			System.out.println("metade");
			return sum;
		}else {
			System.out.println("vazio");
			return sum;
		}
			
	}
	
}