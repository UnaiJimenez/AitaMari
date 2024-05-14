package validacion;

import java.util.Date;

public class MetodosValidacion {
		
		public static boolean esEntero(String edad) {
			
				try {
			        Integer.parseInt(edad);
			        return true; 
			    } catch (NumberFormatException e) {
			        return false; 
			    }
			}		
		
		public static boolean esFechaAnterior(Date fechaSalida, Date fechaLlegada) {

			boolean esFechaAnterior = fechaSalida.before(fechaLlegada);
	        return esFechaAnterior; // Si date1 es anterior a date2
	    }
		
		public static boolean esTipoSangre(String tipoSangre) {
			
			if(tipoSangre.equalsIgnoreCase("A+") | tipoSangre.equalsIgnoreCase("A-") | tipoSangre.equalsIgnoreCase("B+") | tipoSangre.equalsIgnoreCase("B-") | tipoSangre.equalsIgnoreCase("AB+") | tipoSangre.equalsIgnoreCase("AB-") | tipoSangre.equalsIgnoreCase("0+") | tipoSangre.equalsIgnoreCase("0-") | tipoSangre.equalsIgnoreCase("O+") | tipoSangre.equalsIgnoreCase("O-")) {
				return true;
			} else {
				return false;
			}
		}
}