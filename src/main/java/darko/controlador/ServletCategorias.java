package darko.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import darko.dao.MySqlCategoriaDAO;
import darko.dao.MySqlProductosDAO;
import darko.entity.Categoria;
import darko.utils.MySqlConectar;



/**
 * Servlet implementation class ServletCategorias
 */
@WebServlet("/ServletCategorias")
public class ServletCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCategorias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 String tipo = request.getParameter("accion");
		    //validar tipo
	  if (tipo.equals("grabar")) {
		  grabarEventos(request, response);
	  } else if(tipo.equals("eliminar"))
		  eliminarEvento(request,response);
	}

	private void eliminarEvento(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		int catId = Integer.parseInt(id);

		// Inicializar el resultado de la operación
		int result = 0;

		Connection con = null;

		try {
			con = new MySqlConectar().getConectar();
			// Deshabilitar el autocommit para iniciar una transacción
			con.setAutoCommit(false);

			// Eliminar voluntarios inscritos en el evento

			// Eliminar voluntarios que están inscritos en el evento
			int ProductResult = new MySqlProductosDAO().deleteByCattId(catId);

			// Eliminar el evento si y solo si no hubo problemas al eliminar las
			// inscripciones y los voluntarios
			if (ProductResult >= 0) {
				result = new MySqlCategoriaDAO().deleteById(catId);
			} else {
				// Si hubo problemas al eliminar inscripciones o voluntarios, hacer un rollback
				con.rollback();
			}

			// Confirmar la transacción
			con.commit();
			System.out.println("SI");
			String tipoMensaje = "error";
			request.getSession().setAttribute("TIPO_MENSAJE", tipoMensaje);

			request.getSession().setAttribute("MENSAJE", "Evento eliminado");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (con != null) {
					// Si hay una excepción, hacer un rollback
					con.rollback();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (con != null) {
					// Restablecer el autocommit
					con.setAutoCommit(true);
					con.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		response.sendRedirect("categorias.jsp");		
	}

	private void grabarEventos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. recuperar los valores de los controles (cajas) del form
				// usar atributo name.
				String nom, id, des;
				nom = request.getParameter("nombre");
				id = request.getParameter("id");
				des = request.getParameter("descripcion");
			

			
				// 2.Crear objeto de la clase Especialidad
				Categoria bean = new Categoria();
				// 3.Setear los atributos del objeto "bean" con las variables
				bean.setCategoriaID(Integer.parseInt(id));
				bean.setNombre(nom);
				bean.setDescripcion(des);
				String tipoMensaje = "error"; // Color por defecto: rojo
				// 4.invocar al método save y enviar el objeto "bean"
				// validar estado
				if (Integer.parseInt(id) == 0) {
					int estado = new MySqlCategoriaDAO().save(bean);

					if (estado == 1) {
						tipoMensaje = "success"; // Para mensajes de éxito (verde)
						request.getSession().setAttribute("TIPO_MENSAJE", tipoMensaje);
						request.getSession().setAttribute("MENSAJE", "Evento registrado");
					} else {
						request.getSession().setAttribute("MENSAJE", "Error en el registro");
					}
				} else {
					int estado = new MySqlCategoriaDAO().update(bean);

					if (estado == 1) {
						tipoMensaje = "warning";
						request.getSession().setAttribute("TIPO_MENSAJE", tipoMensaje);
						request.getSession().setAttribute("MENSAJE", "Evento actualizado");
					} else {
						tipoMensaje = "error";
						request.getSession().setAttribute("TIPO_MENSAJE", tipoMensaje);
						request.getSession().setAttribute("MENSAJE", "Error en la actualización");
					}
				}

				response.sendRedirect("categorias.jsp");
		
	}

	

}
