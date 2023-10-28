package darko.controlador;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import darko.dao.MySqlProductosDAO;
import darko.entity.Productos;



/**
 * Servlet implementation class ServletProductos
 */
@WebServlet("/ServletProductos")
public class ServletProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    //recuperar el parametro accion
	    String tipo = request.getParameter("accion");
	    //validar tipo
	    if (tipo.equals("guardar")) {
	        grabarProducto(request, response);
	    }else if(tipo.equals("actualizar"))
			actualizarProducto(request,response);
		else if(tipo.equals("eliminar"))
			eliminarProducto(request,response);	
		else if(tipo.equals("setCat"))
			actualizarCategoriaProducto(request,response);	

	}

	private void actualizarCategoriaProducto(HttpServletRequest request, HttpServletResponse response) {
		 // Recuperar los valores de los controles del formulario
	    String codigo = request.getParameter("codigo");
	    String categoria = request.getParameter("categoria");

	    // Crear un objeto de la clase Productos solo con el código y la categoría
	    Productos producto = new Productos();
	    producto.setCodigo(codigo);

	    // Actualizar la categoría utilizando el método de tu DAO
	    int estado = new MySqlProductosDAO().updateCat(producto, categoria);

	    String tipoMensaje = "error"; // Color por defecto: rojo

	    if (estado == 1) {
	        tipoMensaje = "warning";
	        request.getSession().setAttribute("TIPO_MENSAJE", tipoMensaje);
	        request.getSession().setAttribute("MENSAJE", "Categoría actualizada");
	    } else {
	        tipoMensaje = "error";
	        request.getSession().setAttribute("TIPO_MENSAJE", tipoMensaje);
	        request.getSession().setAttribute("MENSAJE", "Error en la actualización de categoría");
		
	}
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id=request.getParameter("id");
		//invocar al método deleteById y enviar la variable "cod"
		int estado=new MySqlProductosDAO().deleteById(Integer.parseInt(id));
		//validar estado
		if(estado==1)
			System.out.println("SI");
		else
			System.out.println("NO");
		//crear atributo de tipo sesión
		request.getSession().setAttribute("MENSAJE","Producto eliminado");
		//invocar método listarDocente
		//listarDocente(request,response);
		response.sendRedirect("productos.jsp");		
	}

	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) {
		 // Recuperar los valores de los controles del formulario
	    String id,nom, cod, cat, prec, stock, des;
	    id = request.getParameter("id");
	    nom = request.getParameter("nombre");
	    cod = request.getParameter("codigo");
	    des = request.getParameter("descripcion");
	    cat = request.getParameter("categoria");
	    prec = request.getParameter("precio");
	    stock = request.getParameter("cantidad");
	 
		
	    // Crear un objeto de la clase Voluntario
	    Productos producto = new Productos();
	    producto.setNombre(nom);
	    producto.setCodigo(cod);
	    producto.setDescripcion(des);
	    producto.setCategoriaID(Integer.parseInt(cat));
	    producto.setPrecioUnitario(Double.parseDouble(prec));
	    producto.setCantidadEnStock(Integer.parseInt(stock));
		int estado=new MySqlProductosDAO().update(producto);
	    String tipoMensaje = "error"; // Color por defecto: rojo


		if(estado==1) {
			tipoMensaje = "warning";
	    	request.getSession().setAttribute("TIPO_MENSAJE", tipoMensaje);
			request.getSession().setAttribute("MENSAJE","Especialidad actualizada");
		}else {
			 tipoMensaje = "error";
			 request.getSession().setAttribute("TIPO_MENSAJE", tipoMensaje);
			request.getSession().setAttribute("MENSAJE","Error en la actualización");
		}
	}

	private void grabarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 // Recuperar los valores de los controles del formulario
	    String id,nom, cod, cat, prec, stock, des;
	    id = request.getParameter("id");
	    nom = request.getParameter("nombre");
	    cod = request.getParameter("codigo");
	    des = request.getParameter("descripcion");
	    cat = request.getParameter("categoria");
	    prec = request.getParameter("precio");
	    stock = request.getParameter("cantidad");
	 
		
	    // Crear un objeto de la clase Voluntario
	    Productos producto = new Productos();
	    producto.setNombre(nom);
	    producto.setCodigo(cod);
	    producto.setDescripcion(des);
	    producto.setCategoriaID(Integer.parseInt(cat));
	    producto.setPrecioUnitario(Double.parseDouble(prec));
	    producto.setCantidadEnStock(Integer.parseInt(stock));


	    // Llamar al método saveVoluntarioEInscripcion en el DAO
	    int estado = new MySqlProductosDAO().save(producto);

		// 5. Validar el estado y mostrar el mensaje de SweetAlert
		// Procesa los datos del formulario y guarda el mensaje en el ámbito de solicitud
		String mensaje = ""; // Inicializa el mensaje
		if (estado == 1) {
		    mensaje = "Los datos se guardaron correctamente.";
		    // Obtener la sesión o crear una nueva
		 // Redirige a la página JSP deseada
			response.sendRedirect("productos.jsp");
		} else {
		    mensaje = "Hubo un problema al guardar los datos.";
		}
		
		// Guarda el mensaje en el ámbito de solicitud
		request.setAttribute("mensaje", mensaje);
		
	}

}
