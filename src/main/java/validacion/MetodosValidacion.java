package validacion;

public class MetodosValidacion {
		
		public static boolean esEntero(String edad) {
			
				try {
			        Integer.parseInt(edad);
			        return true; 
			    } catch (NumberFormatException e) {
			        return false; 
			    }
			}		    
}