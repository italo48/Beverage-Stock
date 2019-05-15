package bvs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import bvs.config.DBConfig;
import bvs.entity.Beverage;

public class BeverageDAO {
	private Session sessionObj;
	private DBConfig dbConn;

	public BeverageDAO(DBConfig dbConn) {
		this.dbConn = dbConn;
	}

	public void addBeverage(Beverage bev) {
		System.out.println(".......Hibernate Maven Example.......\n");
		try {
			sessionObj = dbConn.buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			sessionObj.save(bev);

			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

	public List<Beverage> listAllBeverage() {
		List<Beverage> list = null;
		System.out.println(".......Hibernate Maven Example.......\n");
		try {
			sessionObj = dbConn.buildSessionFactory().openSession();
			sessionObj.beginTransaction(); 

			Criteria crit = sessionObj.createCriteria(Beverage.class);
			list = crit.list();

			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		return list;
	}

	public void removeBeverage(Beverage bev) {
		System.out.println(".......Hibernate Maven Example.......\n");
		try {
			sessionObj = dbConn.buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			sessionObj.delete(bev);
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

	public Beverage alterBerverage(Beverage newBev) {
		Beverage b = null;
		System.out.println(".......Hibernate Maven Example.......\n");
		try {
			sessionObj = dbConn.buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			b = (Beverage) sessionObj.save(newBev);
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		return b;
	}
}
