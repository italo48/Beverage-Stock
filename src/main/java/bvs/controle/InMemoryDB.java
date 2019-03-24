package bvs.controle;

import java.util.ArrayList;

import bvs.entity.Beverage;

public class InMemoryDB {
	private ArrayList<Beverage> db;
	
	public InMemoryDB(ArrayList<Beverage> db) {
		this.db = db;
	}
	public  ArrayList<Beverage> getDb() {
		return db;
	}
}
