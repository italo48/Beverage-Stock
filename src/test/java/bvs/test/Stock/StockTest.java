package bvs.test.Stock;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bvs.controle.InMemoryDB;
import bvs.controle.StockControl;
import bvs.entity.Beverage;

public class StockTest {
	private bvs.controle.StockControl stock;
	private ArrayList<Beverage> beverage;
	private InMemoryDB db;
	
	@Before
	public void setUp() {
		beverage = new ArrayList<>();
		db = new InMemoryDB(beverage);
		stock = new StockControl(db);
		
		Beverage b1 = new Beverage(1, "Ninnoff", "Vodka", 2.50f, (short)20, 375);
		Beverage b2 = new Beverage(2, "Fogo Verde", "Absinto", 3.40f,(short)12, 375);
		b1.setLoss(1);
		
		beverage.add(b1);
		beverage.add(b2);
	}
	@Test
	public void CalculateTheValueInRsTest() {
		float results = 2.50f + 3.40f;
		assertEquals(results, stock.CalculateStock(), 0.001f);
	}
	@Test
	public void LevelStockTest() {
		
		byte expecteds = 50;
		assertEquals(expecteds, stock.LevelStock());
	}
	@Test
	public void LevelBeverageTest() {
		short expecteds = 50;
		assertEquals(expecteds, stock.LevelBeverage(1));
	}
	@Test
	public void ValueStockLossTest() {
		double expecteds = 1;
		assertEquals(expecteds, stock.ValueStockLoss(), 0.00f);
	}
	@Test
	public void RegLostTest() {
		stock.RegLoss(1, 300);
		assertEquals(300, db.getDb().get(0).getLoss());
	}
}
