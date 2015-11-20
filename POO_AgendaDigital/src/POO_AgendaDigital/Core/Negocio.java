package POO_AgendaDigital.Core;

import java.util.ArrayList;

import POO_AgendaDigital.Infraestrutura.SQLite;

public class Negocio {
	
	
	public static boolean isString(String str){
		boolean isString = true;
		
		for(int i = 0; i < str.length(); i++){
			try {
				@SuppressWarnings("unused")
				int convert = Integer.parseInt(new Character(str.charAt(i)).toString());
				isString = false;
			} catch (NumberFormatException e) {
			}
		}
		
		return isString;
	}
	
	
	
	public static ArrayList<Integer> returnListDias(int dias){
		ArrayList<Integer> Dias = new ArrayList<Integer>();
		
		while(dias%10 > 0){
			Dias.add((dias%10));
			dias = dias/10;
		}
		
		return Dias;
	}
	
}
