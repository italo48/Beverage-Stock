package bvs.util;

import bvs.config.DBConfig;
import bvs.dao.BeverageDAO;
import bvs.entity.Beverage;

public class Povoamento {
	private static Povoamento povoaSingleton;
	private DBConfig dbConn = new DBConfig();
	private BeverageDAO bevDAO = new BeverageDAO(dbConn);
	
	public static Povoamento getInstance() {
		if(povoaSingleton == null) povoaSingleton = new Povoamento();
		return povoaSingleton;
	}
	
	public void mulherDoPolvo() {
		for(int i = 3; i < 100; i++) {
			bevDAO.addBeverage(new Beverage(i, "Bebida"+1, "Vodka", 8.99f, (short)20, 120));
		}
	}
}
