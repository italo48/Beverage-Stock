package bvs.dao;

import org.hibernate.Session;

import bvs.config.DBConfig;
import bvs.entity.Beverage;

public class BeverageDAO {
	private Session sessionObj;
	private DBConfig dbConn;
	
	public BeverageDAO(DBConfig dbConn) {
		this.dbConn = dbConn;
	}

	public void cadastrarBebida(Beverage bev) {
		System.out.println(".......Hibernate Maven Example.......\n");
        try {
            sessionObj = dbConn.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            
            sessionObj.save(bev);
            
            System.out.println("\n.......Records Saved Successfully To The Database.......\n");
 
            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }	
	}
}
