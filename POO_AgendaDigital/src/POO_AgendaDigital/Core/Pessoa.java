package POO_AgendaDigital.Core;

import java.util.ArrayList;

public class Pessoa {
	private final int PessoaId;
	private String Nome;
	private int Idade;
	private String DataNascimento;
	private ArrayList<Compromisso> Compromissos;

	public Pessoa(int PessoaId, String Nome, int Idade, String DataNascimento) {
		this.PessoaId = PessoaId;
		this.Nome = Nome;
		this.Idade = Idade;
		this.DataNascimento = DataNascimento;
		Compromissos = new ArrayList<Compromisso>();

	}

	// Region - GETTERS
	
	/**
	 * Método para receber o ID da Pessoa.
	 * @return PessoaId
	 */
	public int getPessoaId() {
		return PessoaId;
	}

	/**
	 * Método para receber o Nome da Pessoa.
	 * @return Nome
	 */
	public String getNome() {
		return Nome;
	}

	/**
	 * Método para receber a Idade da Pessoa.
	 * @return Idade
	 */
	public int getIdade() {
		return Idade;
	}

	/**
	 * Método para receber a Data de Nascimento da Pessoa.
	 * @return DataNascimento
	 */
	public String getDataNascimento() {
		return DataNascimento;
	}

	/**
	 * Método para receber os Compromissos da Pessoa.
	 * @return Compromissos
	 */
	public ArrayList<Compromisso> getCompromissos() {
		return Compromissos;
	}

	// EndRegion

	// Region - SETTERS

	/**
	 * Método para inserir um Nome em uma Pessoa.
	 * @param Nome
	 */
	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	/**
	 * Método para inserir um Compromisso de uma Pessoa.
	 * @param Compromisso
	 */
	public void setCompromisso(Compromisso Compromisso) {
		Compromissos.add(Compromisso);
	}

	/**
	 * Método para inserir uma Data de Nascimento de uma Pessoa.
	 * @param DataNascimento
	 */
	public void setDataNascimento(String DataNascimento) {
		this.DataNascimento = DataNascimento;
	}

	/**
	 * Método para inserir uma Idade de uma Pessoa.
	 * @param Nome
	 */
	public void setIdade(int Idade) {
		this.Idade = Idade;
	}

	// EndRegion
	
	public String toString(){
		return "•" + Nome;
	}
}
