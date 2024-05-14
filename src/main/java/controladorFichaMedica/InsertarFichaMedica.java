package controladorFichaMedica;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.FichaMedica;
import modelo.ModeloFichaMedica;
import modelo.ModeloRescatado;
import modelo.Rescatado;
import validacion.MetodosValidacion;

/**
 * Servlet implementation class InsertarFichaMedica
 */
@WebServlet("/InsertarFichaMedica")
public class InsertarFichaMedica extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertarFichaMedica() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ArrayList<Rescatado> rescatados = ModeloRescatado.getTodos();
		request.setAttribute("rescatados", rescatados);
		request.getRequestDispatcher("FichaMedica/InsertarFichaMedica.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String confirmacion = request.getParameter("Confirmacion");
		boolean esTipoSangre = false;
		boolean noEsTipoSangre = false;
		
		if (confirmacion.equalsIgnoreCase("Insertar")) {

			String constantesVitales = request.getParameter("constantesVitales");
			String alergias = request.getParameter("alergias");
			String tipoSangre = request.getParameter("tipoSangre");
			int idRescatado = Integer.parseInt(request.getParameter("idRescatado"));
			try {
				Rescatado rescatado = ModeloFichaMedica.getRescatado(idRescatado);
				FichaMedica fichaMedica = new FichaMedica();
				fichaMedica.setConstantesVitales(constantesVitales);
				fichaMedica.setAlergias(alergias);
				fichaMedica.setTipoSangre(tipoSangre);
				fichaMedica.setRescatado(rescatado);

				ModeloFichaMedica mfm = new ModeloFichaMedica();

				try {
					if(MetodosValidacion.esTipoSangre(fichaMedica.getTipoSangre()) == true) {
					mfm.insertarFichasMedicas(fichaMedica);
					esTipoSangre = true;
				}else {
					noEsTipoSangre = true;
				}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		request.setAttribute("esTipoSangre", esTipoSangre);
		request.setAttribute("noEsTipoSangre", noEsTipoSangre);
		request.getRequestDispatcher("IndexFichaMedica").forward(request, response);
	}
}