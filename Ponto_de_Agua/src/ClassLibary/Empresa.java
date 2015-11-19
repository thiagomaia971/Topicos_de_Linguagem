package ClassLibary;

import java.util.ArrayList;

public class Empresa {
	private String nome;
	private String endereco;
	private String cnpj;
	private ArrayList<Funcionario> funcionarios;
	private ArrayList<Cliente> clientes;

	public Empresa(String nome, String endereco, String cnpj) {
		this.nome = nome;
		this.endereco = endereco;
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null) {
			this.nome = nome;
		}
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if (endereco != null) {
			this.endereco = endereco;
		}
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		if (cnpj != null) {
			this.cnpj = cnpj;
		}
	}

	public void exibirFuncionarios() {
		for (Funcionario funcionario : funcionarios) {
			funcionario.exibirFuncionario();
			System.out.println();
		}
	}

	public void exibirClientes() {
		for (Cliente cliente : clientes) {
			cliente.exibirCliente();
			System.out.println();
		}
	}

	public void exibirEmpresa() {
		System.out
				.println("<---------------------------------------Empresa--------------------------------->");
		System.out
				.printf("| Nome da Empresa: %-13s  |  Endereço: %-10s  |  CNPJ: %-8s  |\n\n",
						nome, endereco, cnpj);
	}
}
