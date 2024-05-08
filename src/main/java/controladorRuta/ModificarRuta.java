package controladorRuta;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Medico;
import modelo.ModeloMedico;
import modelo.ModeloRuta;
import modelo.ModeloVoluntario;
import modelo.Ruta;
import modelo.Voluntario;

/**
 * Servlet implementation class ModificarRuta
 */
@WebServlet("/ModificarRuta")
public class ModificarRuta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarRuta() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		ArrayList<Voluntario> voluntarios = ModeloVoluntario.getTodos();
		ArrayList<Medico> medicos = ModeloMedico.getTodos();
		request.setAttribute("voluntarios", voluntarios);
		request.setAttribute("medicos", medicos);
		try {
			Ruta ruta = ModeloRuta.verRuta(id);

			request.setAttribute("ruta", ruta);
			request.getRequestDispatcher("ModificarRuta.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String f1 = request.getParameter("fechaSalida");
		String f2 = request.getParameter("fechaLlegada");
		String[] idVoluntarios = request.getParameterValues("idVoluntarios[]");
		String[] idMedicos = request.getParameterValues("idMedicos[]");

		ModeloRuta mr = new ModeloRuta();

		try {
			Date fechaSalida = sdf.parse(f1);
			Date fechaLlegada = sdf.parse(f2);
			String origen = request.getParameter("origen");
			String destino = request.getParameter("destino");

			Ruta ruta = new Ruta();
			ruta.setId(id);
			ruta.setFechaSalida(fechaSalida);
			ruta.setFechaLlegada(fechaLlegada);
			ruta.setOrigen(origen);
			ruta.setDestino(destino);

			try {
				try {
					ModeloRuta.eliminarVoluntario(id);
					for (String idVoluntario : idVoluntarios) {

						try {
							ModeloRuta.insertarVoluntario(id, Integer.parseInt(idVoluntario));
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					ModeloRuta.eliminarMedico(id);
					for (String idMedico : idMedicos) {

						try {
							ModeloRuta.insertarMedico(id, Integer.parseInt(idMedico));
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		response.sendRedirect("IndexRuta");
	}

}
