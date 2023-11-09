package darko.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import darko.dao.MySqlIncidnciasDAO;
import darko.entity.Incidencias;


/**
 * Servlet implementation class ServletIncidencia
 */
@WebServlet("/ServletIncidencia")
public class ServletIncidencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIncidencia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("accion");
		if (tipo.equals("GUARDAR"))
			guardarIncidencia(request, response);
	}

	private void guardarIncidencia(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String productoID, mensaje;
		productoID = request.getParameter("producto");
		mensaje = request.getParameter("mensaje");
		Incidencias incidencia = new Incidencias();
		incidencia.setProductoID(Integer.parseInt(productoID));
		incidencia.setDescripcionIncidencia(mensaje);
		int estado = new MySqlIncidnciasDAO().save(incidencia);
		if(estado == 1) {
			response.sendRedirect("index.jsp");
			System.out.println("yes");
		} else {
			response.sendRedirect("incidencia.jsp");
		}
		
	}

}
