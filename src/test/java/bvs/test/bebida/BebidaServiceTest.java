package bvs.test.bebida;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bvs.controle.BebidaService;
import bvs.entity.Bebida;
import bvs.entity.InMemoryDB;

public class BebidaServiceTest {
	
	private ArrayList<Bebida> bebidas;
	private InMemoryDB db;
	
	private BebidaService bebidaService;
	
	@Before
	public void setUp() {
		bebidas  = new ArrayList<Bebida>();
		db = new InMemoryDB(bebidas);
		bebidaService = new BebidaService(db);
		
		Bebida b1 = new Bebida(1, "Ninnoff", "Vodka", 8.99f, (short)20, 120, false);
		Bebida b2 = new Bebida(2, "Fogo Verde", "Absinto", 190.00f,(short)12, 750, true);
		Bebida b3 = new Bebida(3, "Jack Daniels", "Whysky", 48.99f, (short)20,1522, false);
		Bebida b4 = new Bebida(4, "Fogo santo", "Cachaça", 18.99f, (short)20,2250, false);
		
		bebidas.add(b1);
		bebidas.add(b2);
		bebidas.add(b3);
		bebidas.add(b4);
	}
	
	@Test
	public void sucessoCadastrarBebida() {
//		Entrada definida: objeto b5
		Bebida b5 = new Bebida(5, "Skoll", "Cerveja", 2.99f, (short)5, 10000, false);
//		Saida esperada: true
		assertTrue(bebidaService.adicionarBebida(b5));
	}
	
	@Test
	public void falhaCadastrarBebidaInvalida() {
		Bebida b6 = new Bebida();
		assertFalse(bebidaService.adicionarBebida(b6));
	}
	
	@Test
	public void falhaCadastrarBebidaExistente() {
		Bebida b7 = new Bebida(7, "Skoll", "Cerveja", 2.99f, (short)34, 150, false);
		assertTrue(bebidaService.adicionarBebida(b7));
		assertFalse(bebidaService.adicionarBebida(b7));
	}
}
