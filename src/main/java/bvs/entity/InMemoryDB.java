package bvs.entity;

import java.util.ArrayList;

public class InMemoryDB {
	private ArrayList<Bebida> db;
	
	public InMemoryDB(ArrayList<Bebida> db) {
		this.db = db;
	}
	
	public boolean add(Bebida b) {
		return db.add(b);
	}

	public ArrayList<Bebida> listAll() {
		return this.db;
	}
}
