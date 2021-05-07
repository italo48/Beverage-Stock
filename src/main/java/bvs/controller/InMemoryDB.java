package bvs.controller;

import java.util.ArrayList;

import bvs.entity.Beverage;

public class InMemoryDB {
	private final ArrayList<Beverage> db;
	
	public InMemoryDB(ArrayList<Beverage> db) {
		this.db = db;
	}
	public  ArrayList<Beverage> getDb() {
		return db;
	}
}
