package ClassLibary;

public class Cliente_ {
	private int id;
	private String nome;
	private String endereço;
	private String telefone;
	private String cpf;
	private String dataNasc;
	private int idade;
	private int rg;
	private int qtCliente;
	private Estoque estoque;

	public Cliente_(Estoque estoque, String nome, String cpf, String dataNasc) {
		this.estoque = estoque;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public void comprarProduto(String marca, int qt){
		for(int i = 0; i < estoque.getProdutos().size(); i++){
			if(estoque.getProdutos().get(i).getMarca().equals(marca)){
				estoque.venderProduto(marca, qt);
			}
		}
	}

	public void exibirCliente() {
		System.out
				.println("<--------------------------------------Cliente----------------------------------->");
		System.out
				.printf("| ID: %-4d  |  Nome: %-100s  |  Endereço: %-100s  | Telefone: %-14s | CPF: %-14s | Data de Nascimento: %-10s | Idade: %-3d | RG: %-14s| \n",
						getId(), getNome(), getEndereço(), getTelefone(),
						getCpf(), getDataNasc(), getIdade(), getRg());
	}


}
