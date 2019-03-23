package bvs.test.bebida;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bvs.controle.BeverageControl;
import bvs.controle.InMemoryDB;
import bvs.entity.Beverage;

public class BebidaServiceTest {
	
	private ArrayList<Beverage> bebidas;
	private InMemoryDB db;
	
	private BeverageControl bebidaService;
	
	@Before
	public void setUp() {
		bebidas  = new ArrayList<Beverage>();
		db = new InMemoryDB(bebidas);
		bebidaService = new BeverageControl(db);
		
		Beverage b1 = new Beverage(1, "Ninnoff", "Vodka", 8.99f, (short)20, 120, false);
		Beverage b2 = new Beverage(2, "Fogo Verde", "Absinto", 190.00f,(short)12, 750, true);
		Beverage b3 = new Beverage(3, "Jack Daniels", "Whysky", 48.99f, (short)20,1522, false);
		Beverage b4 = new Beverage(4, "Fogo santo", "Cachaça", 18.99f, (short)20,2250, false);
		
		bebidas.add(b1);
		bebidas.add(b2);
		bebidas.add(b3);
		bebidas.add(b4);
	}
	
	@Test
	public void sucessoCadastrarBebida() {
//		Entrada definida: objeto b5
		Beverage b5 = new Beverage(5, "Skoll", "Cerveja", 2.99f, (short)5, 10000, false);
//		Saida esperada: true
		assertTrue(bebidaService.adicionarBebida(b5));
	}
	
	@Test
	public void falhaCadastrarBebidaInvalida() {
		Beverage b6 = new Beverage();
		assertFalse(bebidaService.adicionarBebida(b6));
	}
	
	@Test
	public void falhaCadastrarBebidaExistente() {
		Beverage b7 = new Beverage(7, "Skoll", "Cerveja", 2.99f, (short)34, 150, false);
		assertTrue(bebidaService.adicionarBebida(b7));
		assertFalse(bebidaService.adicionarBebida(b7));
	}
}
