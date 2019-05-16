package bvs.test.Stock;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import bvs.controle.StockControl;
import bvs.dao.BeverageDAO;
import bvs.entity.Beverage;

public class StockTest {
	private bvs.controle.StockControl stock;

	
	@ Mock
	private BeverageDAO bevDAO;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		stock = new StockControl(bevDAO);
	}
	
	@Test
	public void CalculateTheValueInRsTest() {
		List<Beverage> ls = new ArrayList<>();
		Beverage b2 = new Beverage(2, "Heiniken", "Cerveja", 2.50f, (short)5, 1);
		Beverage b3 = new Beverage(3, "Itaipava", "Cerveja", 3.40f, (short)5, 1);
		ls.add(b2);
		ls.add(b3);
		Mockito.when(bevDAO.listAllBeverage()).thenReturn(ls);
		float results = 2.50f + 3.40f;
		assertEquals(results, stock.CalculateStock(), 0.001f);
		Mockito.verify(bevDAO, Mockito.times(1)).listAllBeverage();
	}
	@Test
	public void LevelStockTest() {
		List<Beverage> ls = new ArrayList<>();
		Beverage b2 = new Beverage(2, "Heiniken", "Cerveja", 2.50f, (short)5, 350);
		Beverage b3 = new Beverage(3, "Itaipava", "Cerveja", 3.40f, (short)5, 350);
		ls.add(b2);
		ls.add(b3);
		Mockito.when(bevDAO.listAllBeverage()).thenReturn(ls);
		byte expecteds = 46;
		assertEquals(expecteds, stock.LevelStock());
		Mockito.verify(bevDAO, Mockito.times(2)).listAllBeverage();

	}
	@Test
	public void LevelBeverageTest() {
		List<Beverage> ls = new ArrayList<>();
		Beverage b2 = new Beverage(2, "Heiniken", "Cerveja", 2.50f, (short)5, 1);
		Beverage b3 = new Beverage(3, "Itaipava", "Cerveja", 3.40f, (short)5, 1);
		ls.add(b2);
		ls.add(b3);
		Mockito.when(bevDAO.listAllBeverage()).thenReturn(ls);
		short expecteds = 50;
		assertEquals(expecteds, stock.LevelBeverage(2));
		Mockito.verify(bevDAO, Mockito.times(2)).listAllBeverage();
	}
//	@Test
//	public void ValueStockLossTest() {
//		List<Beverage> ls = new ArrayList<>();
//		Beverage b2 = new Beverage(2, "Heiniken", "Cerveja", 2.50f, (short)5, 100);
//		Beverage b3 = new Beverage(3, "Itaipava", "Cerveja", 3.40f, (short)5, 100);
//		ls.add(b2);
//		ls.add(b3);
//		stock.RegLoss(2, 100);
//		Mockito.when(bevDAO.listAllBeverage()).thenReturn(ls);
//		double expecteds = 1;
//		assertEquals(expecteds, stock.ValueStockLoss(), 0.00f);
//	}
//	@Test
//	public void RegLostTest() {
//		stock.RegLoss(1, 300);
//		assertEquals(300, bevDAO.listAllBeverage().get(0).getLoss());
//	}
}
