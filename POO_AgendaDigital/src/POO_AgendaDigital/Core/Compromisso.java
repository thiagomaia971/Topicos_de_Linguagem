package POO_AgendaDigital.Core;

import java.util.ArrayList;


public class Compromisso {
	private final int CompromissoId;
	private final int PessoaId;
	private String NomeCompromisso;
	private int Dias;
	//private ArrayList<Integer> Dias;
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

	// Region GETTERS

	public Compromisso(int CompromissoId, int PessoaId, String NomeCompromisso, int dias, String horaInicial,
			String horaFinal) {
		this.CompromissoId = CompromissoId;
		this.PessoaId = PessoaId;
		this.NomeCompromisso = NomeCompromisso;
		//this.Dias = new ArrayList<Integer>();

//		this.Dias.add(dias/10);
//		this.Dias.add(dias/10);
//		this.Dias.add(dias/10);
//		this.Dias.add(dias/10);
		
		int contDias = 0;
		while(dias%10 > 0){
			this.Dias += (dias%10);
			dias = dias/10;
		}
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		
	}

	public String getNomeCompromisso() {
		return NomeCompromisso;
	}

	public int getDias() {
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
