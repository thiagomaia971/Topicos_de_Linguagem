package POO_AgendaDigital.Core;

import java.util.ArrayList;

public class Compromisso {
	
	private final int CompromissoId;
	private final int PessoaId;
	private String NomeCompromisso;
	//private int Dias;
	private ArrayList<Integer> Dias;
	private String horaInicial;
	private String horaFinal;

	/*public Compromisso(int CompromissoId, int PessoaId, String NomeCompromisso, String horaInicial, String horaFinal,
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

	}*/
	
	public Compromisso(){
		CompromissoId = 0;
		PessoaId = 0;
	}
	
	public Compromisso(int CompromissoId, int PessoaId, String NomeCompromisso, int dias, String horaInicial,
			String horaFinal) {
		this.CompromissoId = CompromissoId;
		this.PessoaId = PessoaId;
		this.NomeCompromisso = NomeCompromisso;
		
		this.Dias = Negocio.returnListDias(dias);
		
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		
	}

	// Region GETTERS


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

	// EndRegion

	// Region SETTERS

	public void setNomeCompromisso(String nomeCompromisso) {
		NomeCompromisso = nomeCompromisso;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	// EndRegion

}
