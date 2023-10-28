package darko.controlador;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import darko.dao.MySqlUsuariosDAO;
import darko.entity.Usuarios;

/**
 * Servlet implementation class ServletEmpleados
 */
@WebServlet("/ServletEmpleados")
public class ServletEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEmpleados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String tipo = request.getParameter("accion");
		
		
		if (tipo.equals("INICIAR"))
			iniciarSesion(request, response);
		else if (tipo.equals("CERRAR"))
			cerrarSesion(request,response);
		else if (tipo.equals("grabar"))
			GuardarEmpleado(request, response);
		else if (tipo.equals("listado"))
			ListarEmpleados(request, response);
		else if (tipo.equals("eliminar"))
			EliminarEmpleado(request, response);
	}

	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getSession().setAttribute("CERRAR", "SESSION CERRADA");		
		response.sendRedirect("login.jsp");
	}

	private void EliminarEmpleado(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void ListarEmpleados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("empleados", new MySqlUsuariosDAO().findAll());
		request.getRequestDispatcher("/usuarios.jsp").forward(request, response);
	}

	private void GuardarEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 String  id,login, contraseña, nombre,  correo, rol, activo, username;
	        id = request.getParameter("id");
	        login = request.getParameter("login");
	        contraseña = request.getParameter("contrasena"); // La contraseña en texto plano
	        nombre = request.getParameter("nombre");
	        username = request.getParameter("username");
	        correo = request.getParameter("correo");
	        rol = request.getParameter("rol");
	        activo = request.getParameter("activo");
	        String tipoMensaje = "error";

	        // Generar una sal (salt) aleatoria para la contraseña
	        SecureRandom random = new SecureRandom();
	        byte[] salt = new byte[16];
	        random.nextBytes(salt);

	        // Encriptar la contraseña con sal
	        String contraseñaEncriptada = hashPassword(contraseña, salt);

	        Usuarios empleado = new Usuarios();
	        empleado.setUsuarioID(Integer.parseInt(id));
	        empleado.setCorreoElectronico(login);
	        empleado.setPassword(contraseñaEncriptada); // Guardar la contraseña encriptada
	        empleado.setSalt(salt); // Guardar el salt
	        empleado.setNombre(nombre);
	        empleado.setUsername(username);
	        empleado.setRol(Boolean.parseBoolean(rol));
	        empleado.setActivo(Boolean.parseBoolean(activo));

	        if (empleado.getUsuarioID() == 0) {
				int estado = new MySqlUsuariosDAO().save(empleado);
				if (estado == 1) {
					tipoMensaje = "success";
					request.getSession().setAttribute("TIPO_MENSAJE", tipoMensaje);
					request.getSession().setAttribute("MENSAJE", "Empleado registrado");
					
				} else {
					tipoMensaje = "error";
					request.getSession().setAttribute("TIPO_MENSAJE", tipoMensaje);
					request.getSession().setAttribute("MENSAJE", "Error en el registro");
				}
			} else {
				// Implementa la actualización del empleado aquí
				int estado = new MySqlUsuariosDAO().update(empleado);
				if (estado == 1) {
					tipoMensaje = "warning";
					request.getSession().setAttribute("TIPO_MENSAJE", tipoMensaje);
					request.getSession().setAttribute("MENSAJE", "Empleado actualizado");
				} else {
					tipoMensaje = "error";
					request.getSession().setAttribute("TIPO_MENSAJE", tipoMensaje);
					request.getSession().setAttribute("MENSAJE", "Error en la actualización");
				}
			}
			response.sendRedirect("empleados.jsp");		
	}

	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String vLogin, vClave;
        vLogin = request.getParameter("login");
        vClave = request.getParameter("contrasena");
        System.out.println(vLogin + vClave);

        // Obtener el usuario por su nombre de usuario (login)
        Usuarios usuario = new MySqlUsuariosDAO().iniciarSesion(vLogin);
        System.out.println("Usuario recuperado de la base de datos: " + usuario);

        if (usuario == null) {
            request.getSession().setAttribute("INVALIDO", "USUARIO O CONTRASEÑA INCORRECTA");
            response.sendRedirect("login.jsp");
            return; // Terminar la función
        }

        // Generar el hash de la contraseña ingresada
        String hashIngresado = hashPassword(vClave, usuario.getSalt());
        // Comparar los hashes
        if (hashIngresado.equals(usuario.getPassword())) {
            // Las contraseñas coinciden, el inicio de sesión es exitoso
	        HttpSession session = request.getSession();
            session.setAttribute("datosEmpleado", usuario.getCorreoElectronico());
            response.sendRedirect("empleados.jsp");
            request.getSession().setAttribute("INICIO", "BIENVENIDO");
        } else {
            // Las contraseñas no coinciden, inicio de sesión fallido
            request.getSession().setAttribute("INVALIDO", "USUARIO O CONTRASEÑA INCORRECTA");
            response.sendRedirect("login.jsp");
        }
        }
	
	 private String hashPassword(String password, byte[] salt) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            md.update(salt);
	            byte[] hashedPassword = md.digest(password.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for (byte b : hashedPassword) {
	                sb.append(String.format("%02x", b));
	            }
	            return sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            // Maneja la excepción apropiadamente
	            e.printStackTrace();
	            return null;
	        }
	    }

}
