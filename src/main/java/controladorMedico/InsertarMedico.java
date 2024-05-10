package controladorMedico;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloMedico;
import modelo.Medico;

/**
 * Servlet implementation class InsertarMedico
 */
@WebServlet("/InsertarMedico")
public class InsertarMedico extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarMedico() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        request.getRequestDispatcher("InsertarMedico.jsp").forward(request, response);
    
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String especialidad = request.getParameter("especialidad");
        
        Medico medico = new Medico();
        medico.setNombre(nombre);
        medico.setApellido(apellido);
        medico.setEspecialidad(especialidad);
        
        String confirmacion = request.getParameter("Confirmacion");
        if(confirmacion.equalsIgnoreCase("insertar")) {
        	ModeloMedico mm = new ModeloMedico();
            try {
                mm.insertarMedico(medico);
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
         
        response.sendRedirect("IndexMedico");
    }

}
