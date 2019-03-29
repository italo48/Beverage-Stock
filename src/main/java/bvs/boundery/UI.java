package bvs.boundery;

import java.util.List;

import bvs.entity.Beverage;

public class UI {
	public void logo() {
		System.out.println();
		System.out.println();
		System.out.println("\t +------------------+");
		System.out.println("\t |  Beverage Stock  |");
		System.out.println("\t +------------------+");
		System.out.println();
	}

	public void appMenu() {
		this.logo();
		System.out.println();
		System.out.println("0 - Sair");
		System.out.println("1 - Gerenciar bebidas");
		System.out.println("2 - Gerenciar estoque");
		System.out.println();
		this.askOp();
	}

	public void beverageMenu() {
		this.logo();
		System.out.println("0 - Sair");
		System.out.println("1 - Cadastrar bebida");
		System.out.println("2 - Remover bebida");
		System.out.println("3 - Alterar bebida");
		System.out.println("4 - Listar bebidas");
		System.out.println("5 - Buscar bebida");
		System.out.println();
		this.askOp();
	}

	public void stockMenu() {
		this.logo();
		System.out.println();
		System.out.println("\t +----------+");
		System.out.println("\t |  Stock   |");
		System.out.println("\t +----------+");
		System.out.println();
		System.out.println("0 - Sair");
		System.out.println("1 - Calcular o valor do estoque em R$");
		System.out.println("2 - Calcular o level do estoque");
		System.out.println("3 - Calcular o level de uma bebida");
		System.out.println("4 - Calcular perdas");
		System.out.println();
		this.askOp();
	}

	public void registerBev() {
		this.logo();
		System.out.println();
		System.out.println("\t +---------------------+");
		System.out.println("\t |  Beverage Register  |");
		System.out.println("\t +---------------------+");
		System.out.println();
		System.out.println("Digite em sequência, todos separados por virgula e sem espaços");
		System.out.println();
		System.out.println("id, Nome, Tipo, Preço, Teor alcolico, Quantidade");
		System.out.println();
		this.askOp();
	}

	public void askIsProhibited() {
		System.out.println();
		System.out.print("Essa bebida é proibida(s/n)?: ");
		System.out.println();
	}

	public void showBeverage(Beverage bev) {
		System.out.println();
		System.out.println();
		System.out.println("ID: " + bev.getId());
		System.out.println("Nome: " + bev.getName());
		System.out.println("Preço: R$" + bev.getPrice());
		System.out.println("Tipo: " + bev.getType());
		System.out.println("Teor Alcólico: " + bev.getAlcoholContent() + "%");
		System.out.println("Quantidade: " + bev.getAmount() + " unid");
		if (bev.isProhibited()) {
			System.out.println("Proibida: sim");
		} else {
			System.out.println("Proibida: não");
		}
		System.out.println();
	}

	public void listBev(List<Beverage> list) {
		this.logo();
		System.out.println();
		System.out.println("\t +-----------------+");
		System.out.println("\t |  Beverage List  |");
		System.out.println("\t +-----------------+");
		for (Beverage bev : list) {
			this.showBeverage(bev);
		}
		System.out.println();
	}

	public void delBev() {
		this.logo();
		System.out.println();
		System.out.println("\t +-------------------+");
		System.out.println("\t |  Beverage Remove  |");
		System.out.println("\t +-------------------+");
		System.out.println();
		this.askId();
	}

	public void findBev() {
		this.logo();
		System.out.println();
		System.out.println("\t +-----------------+");
		System.out.println("\t |  Beverage Find  |");
		System.out.println("\t +-----------------+");
		System.out.println();
		this.askId();
	}

	public void altBev() {
		this.logo();
		System.out.println();
		System.out.println("\t +-------------------+");
		System.out.println("\t |  Beverage Update  |");
		System.out.println("\t +-------------------+");
		System.out.println();
		this.askId();
	}

	public void beverageUpdateMenu() {
		System.out.println();
		System.out.println("0 - Sair");
		System.out.println("1 - Alterar nome");
		System.out.println("2 - Alterar tipo");
		System.out.println("3 - Alterar preço");
		System.out.println("4 - Alterar teor alcoolico");
		System.out.println("5 - Alterar quantidade");
		System.out.println("6 - Tornar proibida ");
		System.out.println();
		this.askOp();
	}

	public void askFieldsBeverage(int value) {
		System.out.println();
		if (value == 1) {
			System.out.print("Novo nome: ");
		} else if (value == 2) {
			System.out.print("Novo tipo: ");
		} else if (value == 3) {
			System.out.print("Novo preço: ");
		} else if (value == 4) {
			System.out.print("Novo teor: ");
		} else if (value == 5) {
			System.out.print("Nova quantidade: ");
		} else if(value == 6) {
			System.out.println("Proibida");
		} else {
			this.errorInput();
		}
	}

	public void askId() {
		System.out.println();
		System.out.print("Digite o ID: ");
	}

	public void errorInput() {
		System.out.println();
		System.err.println("Entrada inválida");
		System.out.println();
	}

	public void errorNotFound() {
		System.out.println();
		System.err.println("Bebida não encontrada");
		System.out.println();
	}

	public void bye() {
		System.out.println();
		System.out.println("\t +-------+");
		System.out.println("\t |  BYE  |");
		System.out.println("\t +-------+");
		System.out.println();
	}

	public void selectFailOrSuccessCRUD(int op) {
		System.out.println();
		if (op == 1) {
			System.out.println("Sucesso ao cadastrar");
		} else if (op == 2) {
			System.out.println("Sucesso ao remover");
		} else if (op == 3) {
			System.out.println("Sucesso ao alterar");
		} else if (op == 4) {
			System.out.println("Falha ao cadastrar");
		} else if (op == 5) {
			System.out.println("Falha ao remover");
		} else if (op == 6) {
			System.out.println("Falha ao alterar");
		}
		System.out.println();
	}

	public void askOp() {
		System.out.println();
		System.out.print(">>>>>>: ");
	}
}
