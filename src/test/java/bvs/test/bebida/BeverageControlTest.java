package bvs.test.bebida;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import bvs.conn.DBConnection;
import bvs.controle.BeverageControl;
import bvs.controle.StockControl;
import bvs.dao.BeverageDAO;
import bvs.entity.Beverage;

public class BeverageControlTest {
	
	private BeverageDAO db;
	private BeverageControl beverageControl;
	private StockControl stock;
	
	@Mock
	private DBConnection dbConn;
	
	@Before
	public void setUp() {
		db = new BeverageDAO(dbConn);
		stock = new StockControl(db);
		beverageControl = new BeverageControl(db, stock);
		
	}
	
	@Test
	public void sucessRegisterBeverage() {
		Beverage b5 = new Beverage(5, "Skoll", "Cerveja", 2.99f, (short)5, 100);
		assertTrue(beverageControl.addBeverage(b5));
	}
	
	@Test
	public void failRegisterBeverageInvalid() {
		Beverage b6 = new Beverage();
		assertFalse(beverageControl.addBeverage(b6));
	}
	
	@Test
	public void failRegisterBeverageWithWithParametersInvalid() {
		Beverage bFalse = new Beverage(1, "", "",0.0f,(short)0, 0);
		assertFalse(beverageControl.addBeverage(bFalse));
	}
	
	@Test
	public void failRegisterBeverageSelf() {
		Beverage b7 = new Beverage(7, "Skoll", "Cerveja", 2.99f, (short)34, 150);
		assertTrue(beverageControl.addBeverage(b7));
		assertFalse(beverageControl.addBeverage(b7));
	}
	
	@Test
	public void failRegisterBeverageWithLossGreaterThenAmount() {
		Beverage bTrab = new Beverage(7, "Skoll", "Cerveja", 2.99f, (short)34, 150);
		bTrab.setLoss(1500);
		assertFalse(beverageControl.addBeverage(bTrab));
	}
	
	@Test
	public void listAllBeverage() {
		assertEquals(beverageControl.listBeverage().size(), 4);	
	}
	
	@Test
	public void successRemoveBeverage() {
		assertTrue(beverageControl.delBeverage(1));
	}
	
	@Test
	public void failRemoveBeverageIdInvalid() {
		assertFalse(beverageControl.delBeverage(-1));
	}
	
	@Test
	public void successFindBeverage() {
		Beverage needed = db.listAllBeverage().get(0); 
		assertEquals(needed, beverageControl.findBeverage(needed.getId()));
	}
	
	@Test
	public void failFindBeverageIdInvalid() {
		assertNull(beverageControl.findBeverage(-3));
	}
	
	@Test
	public void successUpdateBeverage() {
		Beverage oldBev = db.listAllBeverage().get(0);
		Beverage newBev = new Beverage(10, "Heiniken", "Cerveja", 4.99f, (short)10, 10000);
		
		assertEquals(newBev, beverageControl.upBeverage(oldBev.getId(), newBev));
	}
	
	@Test
	public void successAltBeverage() {
		Beverage oldBev = db.listAllBeverage().get(0);
		Beverage newBev = new Beverage(11, "Boemia", "Cerveja", 5.99f, (short)20, 1000);
		
		beverageControl.upBeverage(oldBev.getId(), newBev);
		
		assertNotEquals(oldBev, db.listAllBeverage().indexOf(oldBev));
	}
}
