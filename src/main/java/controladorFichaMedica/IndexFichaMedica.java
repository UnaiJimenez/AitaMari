package controladorFichaMedica;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.FichaMedica;
import modelo.ModeloFichaMedica;

/**
 * Servlet implementation class IndexFichaMedica
 */
@WebServlet("/IndexFichaMedica")
public class IndexFichaMedica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexFichaMedica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	ArrayList<FichaMedica> fichasMedicas = ModeloFichaMedica.getTodos();
	request.setAttribute("fichasMedicas", fichasMedicas);
	
	request.getRequestDispatcher("FichaMedicaVerTodos.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
