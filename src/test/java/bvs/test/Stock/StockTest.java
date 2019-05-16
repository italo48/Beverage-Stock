package bvs.test.Stock;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import bvs.conn.DBConnection;
import bvs.controle.StockControl;
import bvs.dao.BeverageDAO;

public class StockTest {
	private bvs.controle.StockControl stock;
	private BeverageDAO bevDAO;
	@ Mock
	private DBConnection db;
	
	@Before
	public void setUp() {
		bevDAO = new BeverageDAO(db);
		stock = new StockControl(bevDAO);
	}
	@Test
	public void CalculateTheValueInRsTest() {
		float results = 2.50f + 3.40f;
		assertEquals(results, stock.CalculateStock(), 0.001f);
	}
	@Test
	public void LevelStockTest() {
		
		byte expecteds = 49;
		assertEquals(expecteds, stock.LevelStock());
	}
	@Test
	public void LevelBeverageTest() {
		short expecteds = 49;
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
		assertEquals(300, bevDAO.listAllBeverage().get(0).getLoss());
	}
}
