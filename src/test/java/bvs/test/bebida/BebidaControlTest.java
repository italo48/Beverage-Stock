package bvs.test.bebida;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bvs.controle.BeverageControl;
import bvs.controle.InMemoryDB;
import bvs.entity.Beverage;

public class BebidaControlTest {
	
	private ArrayList<Beverage> beverage;
	private InMemoryDB db;
	private BeverageControl beverageControl;
	
	@Before
	public void setUp() {
		beverage  = new ArrayList<Beverage>();
		db = new InMemoryDB(beverage);
		beverageControl = new BeverageControl(db);
		
		Beverage b1 = new Beverage(1, "Ninnoff", "Vodka", 8.99f, (short)20, 120, false);
		Beverage b2 = new Beverage(2, "Fogo Verde", "Absinto", 190.00f,(short)12, 750, true);
		Beverage b3 = new Beverage(3, "Jack Daniels", "Whysky", 48.99f, (short)20,1522, false);
		Beverage b4 = new Beverage(4, "Fogo santo", "Cachaça", 18.99f, (short)20,2250, false);
		
		
		beverage.add(b1);
		beverage.add(b2);
		beverage.add(b3);
		beverage.add(b4);
	}
	
	@Test
	public void sucessAccessBeverage() {
//		Entrada definida: objeto b5
		Beverage b5 = new Beverage(5, "Skoll", "Cerveja", 2.99f, (short)5, 10000, false);
//		Saida esperada: true
		assertTrue(beverageControl.addBeverage(b5));
	}
	
	@Test
	public void failAccessBeverageInvalid() {
		Beverage b6 = new Beverage();
		assertFalse(beverageControl.addBeverage(b6));
	}
	
	@Test
	public void failAccessBeverageExistente() {
		Beverage b7 = new Beverage(7, "Skoll", "Cerveja", 2.99f, (short)34, 150, false);
		assertTrue(beverageControl.addBeverage(b7));
		assertFalse(beverageControl.addBeverage(b7));
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
	public void failRemoveBeverage() {
		assertFalse(beverageControl.delBeverage(-1));
	}
	
	@Test
	public void successFindBeverage() {
		Beverage needed = db.getDb().get(0); 
		assertEquals(needed, beverageControl.findBeverage(needed.getId()));
	}
	
	@Test
	public void failFindBeverage() {
		assertNull(beverageControl.findBeverage(-3));
	}
	
	@Test
	public void successPersistChangesInBeverage() {
		Beverage oldBev = db.getDb().get(0);
		Beverage newBev = new Beverage(10, "Heiniken", "Cerveja", 4.99f, (short)10, 10000, false);
		
		assertEquals(newBev, beverageControl.upBeverage(oldBev.getId(), newBev));
	}
	
	@Test
	public void successAltBeverage() {
		Beverage oldBev = db.getDb().get(0);
		Beverage newBev = new Beverage(11, "Boemia", "Cerveja", 5.99f, (short)20, 1000, false);
		
		beverageControl.upBeverage(oldBev.getId(), newBev);
		
		assertNotEquals(oldBev, db.getDb().indexOf(oldBev));
	}
	
	@Test
	public void successRealChangeBeverage() {
		Beverage oldBev = db.getDb().get(0);
		Beverage newBev = new Beverage(11, "Itaipava", "Cerveja", 1.39f, (short)20, 1000, false);
		int oldLen = db.getDb().size();
		
		beverageControl.upBeverage(oldBev.getId(), newBev);
		
		assertEquals(oldLen, db.getDb().size());
	}
}
