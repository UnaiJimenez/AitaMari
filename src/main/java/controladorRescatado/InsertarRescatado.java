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
	    try {
	        String confirmacion = request.getParameter("Confirmacion");

	        if (confirmacion.equalsIgnoreCase("insertar")) {
	            String nacionalidad = request.getParameter("nacionalidad");
	            String nombre = request.getParameter("nombre");
	            String sexo = request.getParameter("sexo");
	            String edad = request.getParameter("edad");
	            int idRescate = Integer.parseInt(request.getParameter("idRescate"));

	            Rescate rescate = ModeloRescatado.getRescate(idRescate);

	            Rescatado rescatado = new Rescatado();
	            rescatado.setNacionalidad(nacionalidad);
	            rescatado.setNombre(nombre);
	            rescatado.setSexo(sexo);
	            rescatado.setEdad(edad);
	            rescatado.setRescate(rescate);

	            ModeloRescatado mr = new ModeloRescatado();
	            mr.insertarRescatado(rescatado);
	        } else if (confirmacion.equalsIgnoreCase("AnadirFichaMedica")) {
	            String nacionalidad = request.getParameter("nacionalidad");
	            String nombre = request.getParameter("nombre");
	            String sexo = request.getParameter("sexo");
	            String edad = request.getParameter("edad");
	            int idRescate = Integer.parseInt(request.getParameter("idRescate"));

	            Rescate rescate = ModeloRescatado.getRescate(idRescate);

	            Rescatado rescatado = new Rescatado();
	            rescatado.setNacionalidad(nacionalidad);
	            rescatado.setNombre(nombre);
	            rescatado.setSexo(sexo);
	            rescatado.setEdad(edad);
	            rescatado.setRescate(rescate);

	            ModeloRescatado mr = new ModeloRescatado();
	            mr.insertarRescatado(rescatado);

	            int idRescatado = ModeloRescatado.getUltimoRescatado();
	            request.setAttribute("idRescatado", idRescatado);
	            request.getRequestDispatcher("RescatadoFichaMedica.jsp").forward(request, response);
	        }

	        response.sendRedirect("IndexRescatado");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
