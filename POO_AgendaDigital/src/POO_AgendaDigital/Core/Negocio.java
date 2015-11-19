package POO_AgendaDigital.Core;

public class Negocio {
	
	
	public static boolean isString(String str){
		boolean isString = true;
		
		for(int i = 0; i < str.length(); i++){
			try {
				int convert = Integer.parseInt(new Character(str.charAt(i)).toString());
				isString = false;
			} catch (NumberFormatException e) {
			}
		}
		
		return isString;
	}
	
	
}
