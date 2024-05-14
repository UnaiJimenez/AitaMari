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
import validacion.MetodosValidacion;

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
		request.setAttribute("voluntarios", voluntarios);
		ArrayList<Medico> medicos = ModeloMedico.getTodos();
		request.setAttribute("medicos", medicos);

		request.getRequestDispatcher("Ruta/InsertarRuta.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean insertOk = false;

        try {
            String confirmacion = request.getParameter("Confirmacion");

            if (confirmacion.equalsIgnoreCase("insertar")) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String f1 = request.getParameter("fechaSalida");
                String f2 = request.getParameter("fechaLlegada");

                Date fechaSalida = sdf.parse(f1);
                Date fechaLlegada = sdf.parse(f2);
                String origen = request.getParameter("origen");
                String destino = request.getParameter("destino");

                Ruta ruta = new Ruta();
                ruta.setFechaSalida(fechaSalida);
                ruta.setFechaLlegada(fechaLlegada);
                ruta.setOrigen(origen);
                ruta.setDestino(destino);

                ModeloRuta mr = new ModeloRuta();
                try {
                    if (MetodosValidacion.esFechaAnterior(ruta.getFechaSalida(), ruta.getFechaLlegada())) {
                        extracted(request, ruta, mr);
                        insertOk = true;
                    } else {
                        insertOk = false;
                    }

                
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            request.setAttribute("insert_ok", insertOk);
            request.getRequestDispatcher("IndexRuta").forward(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

	private void extracted(HttpServletRequest request, Ruta ruta, ModeloRuta mr)
			throws ClassNotFoundException, SQLException {
		mr.insertarRuta(ruta);
		int idUltimaRuta = mr.getUltimaRuta();
		
		String[] idVoluntarios = request.getParameterValues("idVoluntarios[]");
		for (String idVoluntario : idVoluntarios) {
		    try {
		        mr.insertarVoluntario(idUltimaRuta, Integer.parseInt(idVoluntario));
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

		String[] idMedicos = request.getParameterValues("idMedicos[]");
		for (String idMedico : idMedicos) {
		    try {
		        mr.insertarMedico(idUltimaRuta, Integer.parseInt(idMedico));
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	}
}

