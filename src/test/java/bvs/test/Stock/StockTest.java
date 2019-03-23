package bvs.test.Stock;

import static org.junit.Assert.*;

import org.junit.Test;

public class StockTest {
	private bvs.controle.Stock stock;
	@Test
	public void CalculateTheValueInRsTest() {
		float sumexpected = 0;
		float results = 2.50f + 3.40f;
		assertEquals(results, sumexpected, 0.001);
	}

}
