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
 * Servlet implementation class InsertarRuta
 */
@WebServlet("/InsertarRuta")
public class InsertarRuta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertarRuta() {
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
		ArrayList<Voluntario> voluntarios = ModeloVoluntario.getTodos();
		ArrayList<Medico> medicos = ModeloMedico.getTodos();
		request.setAttribute("medicos", medicos);
		request.setAttribute("voluntarios", voluntarios);

		request.getRequestDispatcher("InsertarRuta.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String f1 = request.getParameter("fechaSalida");
		String f2 = request.getParameter("fechaLlegada");
		try {

			Date fechaSalida = sdf.parse(f1);
			Date fechaLlegada = sdf.parse(f2);
			String origen = request.getParameter("origen");
			String destino = request.getParameter("destino");
			

			Ruta ruta = new Ruta();
			ruta.setFechaSalida(fechaSalida);
			ruta.setFechaLlegada(fechaLlegada);
			ruta.setOrigen(origen);
			ruta.setDestino(destino);

			String confirmacion = (request.getParameter("Confirmacion"));
			if(confirmacion.equalsIgnoreCase("insertar")) {
				ModeloRuta mr = new ModeloRuta();
				try {
					mr.insertarRuta(ruta);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		String[] idVoluntarios = request.getParameterValues("idVoluntarios[]");
		String[] idMedicos = request.getParameterValues("idMedicos[]");
		
		for (String idVoluntario : idVoluntarios) {
			ModeloRuta mr = new ModeloRuta();

			try {
				mr.insertarVoluntario(mr.getUltimaRuta(), Integer.parseInt(idVoluntario));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		for (String idMedico : idMedicos) {
			ModeloRuta mr = new ModeloRuta();

			try {
				mr.insertarMedico(mr.getUltimaRuta(), Integer.parseInt(idMedico));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		response.sendRedirect("IndexRuta");

	}

}
