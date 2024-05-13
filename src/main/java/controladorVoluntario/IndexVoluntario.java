package controladorVoluntario;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloVoluntario;
import modelo.Voluntario;
/**
 * Servlet implementation class IndexVoluntarios
 */
@WebServlet("/IndexVoluntario")
public class IndexVoluntario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexVoluntario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	ArrayList<Voluntario> voluntarios = ModeloVoluntario.getTodos();
	request.setAttribute("voluntarios", voluntarios);
	
	//abir la vista principal
	request.getRequestDispatcher("Voluntario/VoluntarioVerTodos.jsp").forward(request, response);
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
