package bvs.test.Stock;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bvs.controle.InMemoryDB;
import bvs.controle.StockControl;
import bvs.entity.Beverage;
import junit.framework.Assert;

public class StockTest {
	private bvs.controle.StockControl stock;
	private ArrayList<Beverage> bebidas;
	private InMemoryDB db;
	
	@Before
	public void setUp() {
		bebidas  = new ArrayList<Beverage>();
		db = new InMemoryDB(bebidas);
		stock = new StockControl(db);
		
		Beverage b1 = new Beverage(1, "Ninnoff", "Vodka", 2.50f, (short)20, 2, 1, false);
		Beverage b2 = new Beverage(2, "Fogo Verde", "Absinto", 3.40f,(short)12, 1, 0, true);
		
		bebidas.add(b1);
		bebidas.add(b2);
	}
	@Test
	public void CalculateTheValueInRsTest() {
		float results = 2.50f + 3.40f;
		assertEquals(results, stock.CalculateStock(), 0.001f);
	}
	@Test
	public void LevelStockTest() {
		
		byte expecteds = 2;
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
}
