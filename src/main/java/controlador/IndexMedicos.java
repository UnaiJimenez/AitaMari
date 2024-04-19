package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloMedico;
import modelo.Medico;
/**
 * Servlet implementation class IndexVoluntarios
 */
@WebServlet("/IndexMedicos")
public class IndexMedicos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexMedicos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {ModeloMedico mm = new ModeloMedico();
	ArrayList<Medico> medicos = mm.getTodos();
	request.setAttribute("medicos", medicos);
	System.out.println(medicos);
	
	//abir la vista principal
	request.getRequestDispatcher("MedicoVerTodos.jsp").forward(request, response);
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
