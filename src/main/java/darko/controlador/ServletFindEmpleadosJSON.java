package darko.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import darko.dao.MySqlUsuariosDAO;
import darko.entity.Usuarios;


/**
 * Servlet implementation class ServletFindEmpleadosJSON
 */
@WebServlet("/ServletFindEmpleadosJSON")
public class ServletFindEmpleadosJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFindEmpleadosJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Usuarios empleado = new MySqlUsuariosDAO().findById(Integer.parseInt(id));
		Gson gson = new Gson();
		String json = gson.toJson(empleado);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(json);	}

}
