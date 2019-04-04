package bvs.BeverageStockApp;

import java.util.ArrayList;
import java.util.Scanner;

import bvs.boundery.UI;
import bvs.controle.BeverageControl;
import bvs.controle.InMemoryDB;
import bvs.controle.StockControl;
import bvs.entity.Beverage;

public class BeverageStockApp {
	private ArrayList<Beverage> beverageDB;
	private InMemoryDB db;
	private BeverageControl bevApp;
	private StockControl stockApp;
	private UI userInterface;

	private Scanner inputApp;

	public void run() {
		beverageDB = new ArrayList<>();
		db = new InMemoryDB(beverageDB);
		stockApp = new StockControl(db);
		bevApp = new BeverageControl(db, stockApp);
		userInterface = new UI();
		inputApp = new Scanner(System.in);

		int op = -1;
		boolean controloop = true;

		do {
			userInterface.appMenu();
			op = inputApp.nextInt();
			if (op == 0) {
				controloop = false;
				this.userInterface.bye();
//				Gerenciar bebidas
			} else if (op == 1) {
				this.beverageApp();
//				Gerenciar estoque
			} else if (op == 2) {
				this.stockApp();
			} else {
				this.userInterface.errorInput();
			}
		} while (controloop);
	}

	public void beverageApp() {
		int op = -1;
		String bev = "";
		long id = 0;
		boolean controloop = true;
		while (controloop) {
			userInterface.beverageMenu();
			op = inputApp.nextInt();
			if (op == 0) {
				userInterface.bye();
				controloop = false;
			} else if (op == 1) {
//				add
				userInterface.registerBev();
				bev = inputApp.next();

				try{
					Beverage beverage = bevApp.toBeverage(bev);
					bev = "";
					userInterface.askIsProhibited();
					bev = inputApp.next();
					if (bev.equals("S") || bev.equals("s")) {
						beverage.setProhibited(true);
					}
					
					if (bevApp.addBeverage(beverage)) {
						userInterface.selectFailOrSuccessCRUD(1);
					} else {
						userInterface.selectFailOrSuccessCRUD(4);
					}
				} catch(Exception e) {
					userInterface.errorParamns();
				}

			} else if (op == 2) {
//				rm
				userInterface.delBev();
				id = inputApp.nextLong();
				if (bevApp.delBeverage(id)) {
					userInterface.selectFailOrSuccessCRUD(2);
				} else {
					userInterface.selectFailOrSuccessCRUD(5);
				}

			} else if (op == 3) {
//				alt
				int opInternal = -1;
				userInterface.altBev();
				id = inputApp.nextLong();
				Beverage finded = bevApp.findBeverage(id);
				if (finded == null) {
					userInterface.errorNotFound();
				} else {
					while (opInternal != 0) {
						userInterface.showBeverage(finded);
						userInterface.beverageUpdateMenu();
						opInternal = inputApp.nextInt();
						if (opInternal == 0) {
							userInterface.bye();
						} else if (opInternal == 1) {
							userInterface.askFieldsBeverage(1);
							String newName = inputApp.next();
							if(bevApp.upBeverage(id, new Beverage(id, newName, finded.getType(), finded.getPrice(),
									finded.getAlcoholContent(), finded.getAmount())) != null) {
								userInterface.selectFailOrSuccessCRUD(3);
							} else {
								userInterface.selectFailOrSuccessCRUD(6);
							}

						} else if (opInternal == 2) {
							userInterface.askFieldsBeverage(2);
							String newType = inputApp.next();
							if(bevApp.upBeverage(id, new Beverage(id, finded.getName(), newType, finded.getPrice(),
									finded.getAlcoholContent(), finded.getAmount())) != null) {
								userInterface.selectFailOrSuccessCRUD(3);
							} else {
								userInterface.selectFailOrSuccessCRUD(6);
							}

						} else if (opInternal == 3) {
							userInterface.askFieldsBeverage(3);
							float newPrice = inputApp.nextFloat();
							if(bevApp.upBeverage(id, new Beverage(id, finded.getName(), finded.getType(), newPrice,
									finded.getAlcoholContent(), finded.getAmount())) != null){
								userInterface.selectFailOrSuccessCRUD(3);
							} else {
								userInterface.selectFailOrSuccessCRUD(6);
							}
						} else if (opInternal == 4) {
							userInterface.askFieldsBeverage(4);
							short newAC = inputApp.nextShort();
							if(bevApp.upBeverage(id, new Beverage(id, finded.getName(), finded.getType(), finded.getPrice(),
									newAC, finded.getAmount())) != null){
								userInterface.selectFailOrSuccessCRUD(3);
							} else {
								userInterface.selectFailOrSuccessCRUD(6);
							}
						} else if (opInternal == 5) {
							userInterface.askFieldsBeverage(5);
							int newAmount = inputApp.nextInt();
							if(bevApp.upBeverage(id, new Beverage(id, finded.getName(), finded.getType(), finded.getPrice(),
									finded.getAlcoholContent(), newAmount))!= null){
								userInterface.selectFailOrSuccessCRUD(3);
							} else {
								userInterface.selectFailOrSuccessCRUD(6);
							}
						} else if (opInternal == 6) {
							userInterface.askFieldsBeverage(6);
							finded.setProhibited(!finded.isProhibited());
						}
					}
				}
			} else if (op == 4) {
//				list
				userInterface.listBev(bevApp.listBeverage());
			} else if (op == 5) {
//				search
				userInterface.findBev();
				id = inputApp.nextLong();
				Beverage finded = bevApp.findBeverage(id);
				if (finded == null) {
					userInterface.errorNotFound();
				} else {
					userInterface.showBeverage(finded);
				}
			} else {
				this.userInterface.errorInput();
			}
		}
	}

	public void stockApp() {
		int op = -1;
		boolean controloop = true;
		while (controloop) {
			userInterface.stockMenu();
			op = inputApp.nextInt();
			
			if (op == 0) {
				userInterface.bye();
				controloop = false;

			} else if (op == 1) {
//				Calcular o valor do estoque em R$
				userInterface.calculateStock(stockApp.CalculateStock());
			} else if (op == 2) {
//				ver level do stock
				userInterface.levelStock(stockApp.LevelStock());
			} else if (op == 3) {
				//ver level da bebida
				userInterface.askId();
				int id = inputApp.nextInt();
				if (id != 0) {
					userInterface.levelBeverage(stockApp.LevelBeverage(id));
				}else {
					userInterface.errorInput();
				}
			} else if (op == 4) {
				// calcular perdas
				userInterface.valueStockLoss(stockApp.ValueStockLoss());
			} else if (op == 5) {
				// cadastrar perdas
				userInterface.askId();
				int id = inputApp.nextInt();
				userInterface.askQtd();
				int qtdLost = inputApp.nextInt();
				if (stockApp.RegLoss(id, qtdLost)) {
					userInterface.regLost();
					userInterface.selectFailOrSuccessCRUD(3);
				}else {
					userInterface.selectFailOrSuccessCRUD(6);
				}
			} else {
				this.userInterface.errorInput();
			}
		}
	}
}
