package Classes;

public class Produto {
	private String Nome;
	private double Quantidade;
	private double Peso;
	
	public Produto(){
		
	}
	
	public Produto(String Nome, double Quantidade, double Peso){
		this.Nome = Nome;
		this.Quantidade = Quantidade;
		this.Peso = Peso;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public double getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(double quantidade) {
		Quantidade = quantidade;
	}

	public double getPeso() {
		return Peso;
	}

	public void setPeso(double peso) {
		Peso = peso;
	}
	
	
	
}
