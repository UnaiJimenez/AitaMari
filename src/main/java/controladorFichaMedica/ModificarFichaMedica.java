package controladorFichaMedica;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.FichaMedica;
import modelo.ModeloFichaMedica;

/**
 * Servlet implementation class ModificarFichaMedica
 */
@WebServlet("/ModificarFichaMedica")
public class ModificarFichaMedica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarFichaMedica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			FichaMedica fichaMedica = ModeloFichaMedica.verFichaMedica(id);
			
			request.setAttribute("fichaMedica", fichaMedica);
			request.getRequestDispatcher("ModificarFichaMedica.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String constantesVitales = request.getParameter("constantesVitales");
		String alergias = request.getParameter("alergias");
		String tipoSangre = request.getParameter("tipoSangre");
		int idRescatado = Integer.parseInt(request.getParameter("idRescatado"));
		
		FichaMedica fichaMedica = new FichaMedica();
		fichaMedica.setId(id);
		fichaMedica.setConstantesVitales(constantesVitales);
		fichaMedica.setAlergias(alergias);
		fichaMedica.setTipoSangre(tipoSangre);
		fichaMedica.setIdRescatado(idRescatado);
		
		ModeloFichaMedica mfm = new ModeloFichaMedica();
		try {
			mfm.modificar(fichaMedica);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			
		}
		
		response.sendRedirect("IndexFichaMedica");
		}

}
