package darko.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import darko.dao.MySqlDiccionarioDAO;
import darko.entity.Diccionario;

/**
 * Servlet implementation class ServletFallas
 */
@WebServlet("/ServletFallas")
public class ServletFallas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFallas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("accion");
		if (tipo.equals("GUARDAR"))
			guardarFalla(request, response);
	}

	private void guardarFalla(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String falla;
		falla = request.getParameter("mensaje");
		Diccionario diccionario = new Diccionario();
		diccionario.setDescripcionFalla(falla);
		int estado = new MySqlDiccionarioDAO().save(diccionario);
		if(estado == 1) {
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("dicfallas.jsp");
		}
	}

}
