package ClassLibary;

public class Produto {
	private int id;
	private String marca;
	private int qtdeProduto;
	private double precoUnitario;

	public Produto(String marca, int qtdeProduto, double precoUnitario) {
		this.marca = marca;
		this.qtdeProduto = qtdeProduto;
		this.precoUnitario = precoUnitario;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		if (precoUnitario > 0) {
			this.precoUnitario = precoUnitario;
		}
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getId() {
		return id;
	}

	public int getQtProduto() {
		return qtdeProduto;
	}

	public void setQtProduto(int qtProduto) {
		if (qtProduto > 0) {
			this.qtdeProduto = qtProduto;
		}
	}

	/*
	 * public Produto(String nome){ for (iterable_type iterable_element :
	 * iterable) {
	 * 
	 * } }
	 */

}
