package bvs.controle;

import bvs.entity.Bebida;
import bvs.entity.InMemoryDB;

public class BebidaService {
	private InMemoryDB db;

	public BebidaService(InMemoryDB b) {
		this.db = b;
	}
	
	public boolean adicionarBebida(Bebida b) {
//		Refatoração
//		O teste é: se o software salva uma bebida com construtor vazio.
//		A checagem disso é aqui?
		
//		se cadastra bebidas nulas ou invalidas
		if (b.getId() <  0) {
			return false;
		}
//		se cadastra uma bebida ja cadastrada
		if(this.db.listAll().indexOf(b) != -1) {
			return false;
		}
		return db.add(b);
	}
}
