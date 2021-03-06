package POO_AgendaDigital.Core;

import java.util.ArrayList;

public class Pessoa {
	private int PessoaId;
	private String Nome;
	private String DataNascimento;
	private ArrayList<Compromisso> Compromissos;

	public Pessoa(String Nome, String DataNascimento) {
		//this.PessoaId = PessoaId;
		this.Nome = Nome;
		this.DataNascimento = DataNascimento;
		Compromissos = new ArrayList<Compromisso>();
	}
	
	public Pessoa(int PessoaId, String Nome, String DataNascimento) {
		this.PessoaId = PessoaId;
		this.Nome = Nome;
		this.DataNascimento = DataNascimento;
		Compromissos = new ArrayList<Compromisso>();

	}

	// Region - GETTERS
	
	public Pessoa() {
		this.PessoaId = 0;
	}

	/**
	 * M�todo para receber o ID da Pessoa.
	 * @return PessoaId
	 */
	public int getPessoaId() {
		return PessoaId;
	}

	/**
	 * M�todo para receber o Nome da Pessoa.
	 * @return Nome
	 */
	public String getNome() {
		return Nome;
	}

	/**
	 * M�todo para receber a Data de Nascimento da Pessoa.
	 * @return DataNascimento
	 */
	public String getDataNascimento() {
		return DataNascimento;
	}

	/**
	 * M�todo para receber os Compromissos da Pessoa.
	 * @return Compromissos
	 */
	public ArrayList<Compromisso> getCompromissos() {
		return Compromissos;
	}

	// EndRegion

	// Region - SETTERS

	/**
	 * M�todo para inserir um Nome em uma Pessoa.
	 * @param Nome
	 */
	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	/**
	 * M�todo para inserir um Compromisso de uma Pessoa.
	 * @param Compromisso
	 */
	public void setCompromisso(Compromisso Compromisso) {
		Compromissos.add(Compromisso);
	}

	/**
	 * M�todo para inserir uma Data de Nascimento de uma Pessoa.
	 * @param DataNascimento
	 */
	public void setDataNascimento(String DataNascimento) {
		this.DataNascimento = DataNascimento;
	}

	// EndRegion
	
	@Override
	public String toString(){
		return "�" + Nome;
	}
}
