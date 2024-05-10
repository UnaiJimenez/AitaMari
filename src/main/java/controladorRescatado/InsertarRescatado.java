package controladorRescatado;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloRescatado;
import modelo.ModeloRescate;
import modelo.ModeloRuta;
import modelo.Rescatado;
import modelo.Rescate;
import modelo.Ruta;

/**
 * Servlet implementation class InsertarRescatado
 */
@WebServlet("/InsertarRescatado")
public class InsertarRescatado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarRescatado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<Rescate> rescates = ModeloRescate.getTodos();
		request.setAttribute("rescates", rescates);
		request.getRequestDispatcher("InsertarRescatado.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nacionalidad = request.getParameter("nacionalidad");
	    String nombre = request.getParameter("nombre");
	    String sexo = request.getParameter("sexo");
	    String edad = request.getParameter("edad");
	    int idRescate = Integer.parseInt(request.getParameter("idRescate"));

	    try {
	        Rescate rescate = ModeloRescatado.getRescate(idRescate);

	        Rescatado rescatado = new Rescatado();
	        rescatado.setNacionalidad(nacionalidad);
	        rescatado.setNombre(nombre);
	        rescatado.setSexo(sexo);
	        rescatado.setEdad(edad);
	        rescatado.setRescate(rescate);

	        String confirmacion = request.getParameter("Confirmacion");
	        ModeloRescatado mr = new ModeloRescatado();	

	        if (confirmacion.equalsIgnoreCase("Insertar")) {
	            try {
	                mr.insertarRescatado(rescatado);
	            } catch (ClassNotFoundException e) {
	                e.printStackTrace();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        } else if (confirmacion.equalsIgnoreCase("AnadirFichaMedica")) {
	            try {
	                mr.insertarRescatado(rescatado);
	                int idRescatado = ModeloRescatado.getUltimoRescatado();
	                request.setAttribute("idRescatado", idRescatado);
	                request.getRequestDispatcher("RescatadoFichaMedica.jsp").forward(request, response);
	            } catch (ClassNotFoundException e) {
	                e.printStackTrace();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        } 
	        response.sendRedirect("IndexRescatado");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
