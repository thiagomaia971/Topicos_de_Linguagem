package POO_AgendaDigital.Core;

public class Dia {
	private final int DiaId;
	private final int CompromissoId;
	
	private String Dia_Semana;
	private String HoraInicial;
	private String HoraFinal;

	public Dia(int DiaId, int CompromissoId, String Dia_Semana, String HoraInicial, String HoraFinal) {
		this.DiaId = DiaId;
		this.CompromissoId = CompromissoId;
		
		this.Dia_Semana = Dia_Semana;
		this.HoraInicial = HoraInicial;
		this.HoraFinal = HoraFinal;

	}
	
	public Dia(String Dia_Semana, String HoraInicial, String HoraFinal) {
		this.DiaId = 0;
		this.CompromissoId = 0;
		
		this.Dia_Semana = Dia_Semana;
		this.HoraInicial = HoraInicial;
		this.HoraFinal = HoraFinal;

	}

	public String getDia_Semana() {
		return Dia_Semana;
	}

	public void setDia_Semana(String dia_Semana) {
		Dia_Semana = dia_Semana;
	}

	public String getHoraInicial() {
		return HoraInicial;
	}

	public void setHoraInicial(String horaInicial) {
		HoraInicial = horaInicial;
	}

	public String getHoraFinal() {
		return HoraFinal;
	}

	public void setHoraFinal(String horaFinal) {
		HoraFinal = horaFinal;
	}

	public int getDiaId() {
		return DiaId;
	}

	public int getCompromissoId() {
		return CompromissoId;
	}

}
