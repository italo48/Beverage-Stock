package bvs.test.bebida;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import bvs.controle.BeverageControl;
import bvs.controle.StockControl;
import bvs.dao.BeverageDAO;
import bvs.entity.Beverage;

public class BeverageControlTest {
	
	private BeverageControl beverageControl;
	private StockControl stock;
	
	@Mock
	private BeverageDAO bevDAO;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		stock = new StockControl(bevDAO);
		beverageControl = new BeverageControl(bevDAO, stock);	
	}
//	Teste que era pra dar certo
	@Test
	public void successFindBeverage() {
		List<Beverage> ls = new ArrayList<>();
		Beverage b2 = new Beverage(2, "Heiniken", "Cerveja", 5.99f, (short)5, 100);
		Beverage b3 = new Beverage(3, "Itaipava", "Cerveja", 1.99f, (short)5, 100);
		Beverage b5 = new Beverage(5, "Skoll", "Cerveja", 2.99f, (short)5, 100);
		
		ls.add(b5);
		ls.add(b3);
		ls.add(b2);
		
		Mockito.when(bevDAO.listAllBeverage()).thenReturn(ls);
		
		Beverage finded = beverageControl.listBeverage().get(0);
		
		assertEquals(b5, finded);
		
		Mockito.verify(bevDAO, Mockito.times(1)).listAllBeverage();
	}
	
//	@Test
//	public void sucessRegisterBeverage() {
//		Beverage b5 = new Beverage(5, "Skoll", "Cerveja", 2.99f, (short)5, 100);
//		assertTrue(beverageControl.addBeverage(b5));
//	}
//	
//	@Test
//	public void failRegisterBeverageInvalid() {
//		Beverage b6 = new Beverage();
//		assertFalse(beverageControl.addBeverage(b6));
//	}
//	
//	@Test
//	public void failRegisterBeverageWithWithParametersInvalid() {
//		Beverage bFalse = new Beverage(1, "", "",0.0f,(short)0, 0);
//		assertFalse(beverageControl.addBeverage(bFalse));
//	}
//	
//	@Test
//	public void failRegisterBeverageSelf() {
//		Beverage b7 = new Beverage(7, "Skoll", "Cerveja", 2.99f, (short)34, 150);
//		assertTrue(beverageControl.addBeverage(b7));
//		assertFalse(beverageControl.addBeverage(b7));
//	}
//	
//	@Test
//	public void failRegisterBeverageWithLossGreaterThenAmount() {
//		Beverage bTrab = new Beverage(7, "Skoll", "Cerveja", 2.99f, (short)34, 150);
//		bTrab.setLoss(1500);
//		assertFalse(beverageControl.addBeverage(bTrab));
//	}
//	
//	@Test
//	public void listAllBeverage() {
//		assertEquals(beverageControl.listBeverage().size(), 4);	
//	}
//	
//	@Test
//	public void successRemoveBeverage() {
//		assertTrue(beverageControl.delBeverage(1));
//	}
//	
//	@Test
//	public void failRemoveBeverageIdInvalid() {
//		assertFalse(beverageControl.delBeverage(-1));
//	}
//	
//	@Test
//	public void failFindBeverageIdInvalid() {
//		assertNull(beverageControl.findBeverage(-3));
//	}
//	
//	@Test
//	public void successUpdateBeverage() {
//		Beverage oldBev = bevDAO.listAllBeverage().get(0);
//		Beverage newBev = new Beverage(10, "Heiniken", "Cerveja", 4.99f, (short)10, 10000);
//		
//		assertEquals(newBev, beverageControl.upBeverage(oldBev.getId(), newBev));
//	}
//	
//	@Test
//	public void successAltBeverage() {
//		Beverage oldBev = bevDAO.listAllBeverage().get(0);
//		Beverage newBev = new Beverage(11, "Boemia", "Cerveja", 5.99f, (short)20, 1000);
//		
//		beverageControl.upBeverage(oldBev.getId(), newBev);
//		
//		assertNotEquals(oldBev, bevDAO.listAllBeverage().indexOf(oldBev));
//	}
}