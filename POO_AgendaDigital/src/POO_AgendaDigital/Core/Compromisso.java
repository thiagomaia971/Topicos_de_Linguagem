package POO_AgendaDigital.Core;

import java.util.ArrayList;

public class Compromisso {
	private final int CompromissoId;
	private final int PessoaId;
	private String NomeCompromisso;
	private ArrayList<Integer> Dias;
	private String horaInicial;
	private String horaFinal;

	public Compromisso(int CompromissoId, int PessoaId, String NomeCompromisso, String horaInicial, String horaFinal,
			int... dias) {
		this.CompromissoId = CompromissoId;
		this.PessoaId = PessoaId;
		this.NomeCompromisso = NomeCompromisso;
		this.Dias = new ArrayList<Integer>();
		for (int i : dias) {
			Dias.add(i);
		}
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;

	}

	//Region GETTERS
	
	public String getNomeCompromisso() {
		return NomeCompromisso;
	}
	
	public ArrayList<Integer> getDias() {
		return Dias;
	}
	
	public String getHoraInicial() {
		return horaInicial;
	}
	
	public String getHoraFinal() {
		return horaFinal;
	}

	public int getCompromissoId() {
		return CompromissoId;
	}

	
	public int getPessoaId() {
		return PessoaId;
	}
	
	//EndRegion
	
	//Region SETTERS
	
	public void setNomeCompromisso(String nomeCompromisso) {
		NomeCompromisso = nomeCompromisso;
	}
	
	
	public void setDias(ArrayList<Integer> dias) {
		Dias = dias;
	}
	
	
	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}
	
	
	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	
	//EndRegion
	
	
}
