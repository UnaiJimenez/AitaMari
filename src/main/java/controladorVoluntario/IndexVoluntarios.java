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
@WebServlet("/IndexVoluntarios")
public class IndexVoluntarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexVoluntarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloVoluntario mv = new ModeloVoluntario();
	ArrayList<Voluntario> voluntarios = mv.getTodos();
	request.setAttribute("voluntarios", voluntarios);
	
	//abir la vista principal
	request.getRequestDispatcher("VoluntarioVerTodos.jsp").forward(request, response);
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
