package bvs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bvs.conn.DBConnection;
import bvs.entity.Beverage;

public class BeverageDAO {
	private DBConnection dbConn;

	public BeverageDAO(DBConnection dbConn) {
		this.dbConn = dbConn;
	}

	public Beverage addBeverage(Beverage bev) {
		try {
			dbConn.conn().createStatement()
					.executeQuery("INSERT INTO Beverage (id, alcoholcontent, amount, isprohibited, loss,"
							+ "name, price, type) VALUES(" + bev.getId() + "," + bev.getAlcoholContent() + ","
							+ bev.getAmount() + "," + bev.isProhibited() + "," + bev.getLoss() + "," + bev.getName()
							+ "," + bev.getPrice() + "," + bev.getType() + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConn.closeConn();
		}
		return bev;
	}

	public List<Beverage> listAllBeverage() {
		List<Beverage> ls = new ArrayList<>();
		try {
			ResultSet setRes = dbConn.conn().createStatement().executeQuery("SELECT * FROM Beverage;");

			while (setRes.next()) {
				ls.add(new Beverage(setRes.getInt("id"), setRes.getString("name"), setRes.getString("type"),
						setRes.getFloat("price"), setRes.getShort("alcoholContent"), setRes.getInt("amount")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConn.closeConn();
		}
		return ls;
	}

	public void removeBeverage(Beverage bev) {

	}

	public Beverage alterBerverage(Beverage newBev) {
		return null;
	}
}