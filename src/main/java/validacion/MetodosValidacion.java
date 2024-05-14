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
}