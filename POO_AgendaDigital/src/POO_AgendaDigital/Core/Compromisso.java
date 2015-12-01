package POO_AgendaDigital.Core;

import java.util.ArrayList;

import javax.swing.JTextField;

public class Compromisso {
	
	private final int CompromissoId;
	private final int PessoaId;
	
	private String NomeCompromisso;
	private ArrayList<Dia> Dias;
	
	public Compromisso(){
		CompromissoId = 0;
		PessoaId = 0;
	}
	
	public Compromisso(int CompromissoId, int PessoaId, String NomeCompromisso, ArrayList<Dia> Dias) {
		this.CompromissoId = CompromissoId;
		this.PessoaId = PessoaId;
		this.NomeCompromisso = NomeCompromisso;
		this.Dias = Dias;
	}

	public Compromisso(int PessoaId, String NomeCompromisso, ArrayList<Dia> Dias) {
		this.CompromissoId = 0;
		this.PessoaId = PessoaId;
		this.NomeCompromisso = NomeCompromisso;
		this.Dias = Dias;
	}
	
	// Region GETTERS


	public Compromisso(int PessoaId, String NomeCompromisso) {
		this.CompromissoId = 0;
		this.PessoaId = PessoaId;
		this.NomeCompromisso = NomeCompromisso;
	}

	public String getNomeCompromisso() {
		return NomeCompromisso;
	}

	public ArrayList<Dia> getDias() {
		return Dias;
	}

	public int getCompromissoId() {
		return CompromissoId;
	}

	public int getPessoaId() {
		return PessoaId;
	}

	// EndRegion

	// Region SETTERS

	public void setNomeCompromisso(String nomeCompromisso) {
		NomeCompromisso = nomeCompromisso;
	}

	// EndRegion

}
