package Classes;

import java.util.HashMap;

public class Geladeira {

	private String Marca;
	private HashMap<String, Produto> produtos;
	private double Capacidade;
	
	public Geladeira(){
		produtos = new HashMap<String, Produto>();
	}

	public Geladeira(String Marca, double Altura, double Largura, double Peso, double Capacidade){
		this.Marca = Marca;
		this.Capacidade = Capacidade;
		produtos = new HashMap<String, Produto>();
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public double getCapacidade() {
		return Capacidade;
	}

	public void setCapacidade(double capacidade) {
		Capacidade = capacidade;
	}
	
	public void adicionarProduto(Produto Produto){
		produtos.put(Produto.getNome(), Produto);
	}
	
	public void removerProduto(String Nome){
		if(seProdutoExiste(Nome)){
			produtos.remove(Nome);
		}
	}
	
	public Produto pesquisarProduto(String Nome){
		if(seProdutoExiste(Nome)){
			return produtos.get(Nome);
		}
		return null;
	}
	
	public boolean seProdutoExiste(String Nome){
		if(produtos.containsKey(Nome)){
			return true;
		}else{
			System.out.println("Não existe este produto!");
		}
		return false;
	}
	
}
