package POO_AgendaDigital.Core;

import java.util.ArrayList;

import POO_AgendaDigital.Infraestrutura.SQLite;

public class Semana {
	ArrayList<Compromisso> compromissos;

	public Semana() {
		compromissos = SQLite.getCompromisso();
	}

	/*public static ArrayList<Compromisso> getDiaDaSemana(int Dia) {
		ArrayList<Compromisso> compromissosSegunda = new ArrayList<Compromisso>();

		ArrayList<Compromisso> allCompromissos = SQLite.getCompromisso();

		for (Compromisso item : allCompromissos) {
			for (int d : item.getDias()) {
				if (d == Dia) {
					compromissosSegunda.add(item);
				}

			}
		}

		return compromissosSegunda;
	}*/
	
}
