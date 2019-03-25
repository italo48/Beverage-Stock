package bvs.entity;

public class Beverage {
	private long id;
	private String nome;
	private String tipo;
	private float preco;
	private short teorAlcolico;
	private int qtd;
	private boolean isProibida;
	
	public Beverage() {
	}

	public Beverage(long id, String nome, String tipo, float preco, short teorAlc, int qtd,boolean isProibida) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
		this.teorAlcolico = teorAlc;
		this.qtd = qtd;
		this.isProibida = isProibida;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	public short getTeorAlcolico() {
		return teorAlcolico;
	}

	public void setTeorAlcolico(short teorAlcolico) {
		this.teorAlcolico = teorAlcolico;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean getIsProibida() {
		return isProibida;
	}

	public void setProibida(boolean isProibida) {
		this.isProibida = isProibida;
	}
}
