package darko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import darko.entity.Usuarios;
import darko.interfaces.UsuariosDAO;
import darko.utils.MySqlConectar;

public class MySqlUsuariosDAO implements UsuariosDAO{

	@Override
	public int save(Usuarios bean) {
		int salida = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    try {
	        cn = new MySqlConectar().getConectar();
	        String sql = "INSERT INTO usuarios(Nombre, Username, Password, Rol, CorreoElectronico, Activo, salt) VALUES (?,?,?,?,?,?,?)";
	        pstm = cn.prepareStatement(sql);
	        pstm.setString(1, bean.getNombre());
	        pstm.setString(2, bean.getUsername());
	        pstm.setString(3, bean.getPassword());
	        pstm.setBoolean(4, bean.isRol());
	        pstm.setString(5, bean.getCorreoElectronico());
	        pstm.setBoolean(6, bean.isActivo());
	        pstm.setBytes(7, bean.getSalt()); // Insertar el valor de salt como un arreglo de bytes

	        salida = pstm.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstm != null)
	                pstm.close();
	            if (cn != null)
	                cn.close();
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
	    return salida;
	}

	@Override
	public int update(Usuarios bean) {
		int salida = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    try {
	        cn = new MySqlConectar().getConectar();
	        String sql = "UPDATE usuarios SET Nombre = ?, Password = ?, Rol = ?, CorreoElectronico = ?, Activo = ? WHERE Username = ?";
	        pstm = cn.prepareStatement(sql);
	        pstm.setString(1, bean.getNombre());
	        pstm.setString(2, bean.getPassword());
	        pstm.setBoolean(3, bean.isRol());
	        pstm.setString(4, bean.getCorreoElectronico());
	        pstm.setBoolean(5, bean.isActivo());
	        pstm.setString(6, bean.getUsername());

	        salida = pstm.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstm != null)
	                pstm.close();
	            if (cn != null)
	                cn.close();
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
	    return salida;
	}

	@Override
	public int deleteById(int cod) {
		 int salida = -1;
		    Connection cn = null;
		    PreparedStatement pstm = null;
		    try {
		        cn = new MySqlConectar().getConectar();
		        String sql = "DELETE FROM usuarios WHERE UsuariosID = ?";
		        pstm = cn.prepareStatement(sql);
		        pstm.setInt(1, cod);

		        salida = pstm.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (pstm != null)
		                pstm.close();
		            if (cn != null)
		                cn.close();
		        } catch (Exception e2) {
		            e2.printStackTrace();
		        }
		    }
		    return salida;
	}

	@Override
	public Usuarios findById(int cod) {
		 Usuarios usuario = null;
		    Connection cn = null;
		    PreparedStatement pstm = null;
		    ResultSet rs = null;
		    try {
		        cn = new MySqlConectar().getConectar();
		        String sql = "SELECT * FROM usuarios WHERE UsuarioID = ?";
		        pstm = cn.prepareStatement(sql);
		        pstm.setInt(1, cod);

		        rs = pstm.executeQuery();
		        if (rs.next()) {
		            usuario = new Usuarios();
		            usuario.setUsuarioID(rs.getInt("UsuarioID"));
		            usuario.setNombre(rs.getString("Nombre"));
		            usuario.setUsername(rs.getString("Username"));
		            usuario.setPassword(rs.getString("Password"));
		            usuario.setRol(rs.getBoolean("Rol"));
		            usuario.setCorreoElectronico(rs.getString("CorreoElectronico"));
		            usuario.setActivo(rs.getBoolean("Activo"));
		            
		            // Otros campos de la entidad

		            // Puedes asignar otros campos de la entidad de manera similar
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (rs != null)
		                rs.close();
		            if (pstm != null)
		                pstm.close();
		            if (cn != null)
		                cn.close();
		        } catch (Exception e2) {
		            e2.printStackTrace();
		        }
		    }
		    return usuario;
	}

	@Override
	public List<Usuarios> findAll() {
		List<Usuarios> usuarios = new ArrayList<>();
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	    try {
	        cn = new MySqlConectar().getConectar();
	        String sql = "SELECT * FROM usuarios";
	        pstm = cn.prepareStatement(sql);

	        rs = pstm.executeQuery();
	        while (rs.next()) {
	            Usuarios usuario = new Usuarios();
	            usuario.setUsuarioID(rs.getInt("UsuarioID"));
	            usuario.setNombre(rs.getString("Nombre"));
	            usuario.setUsername(rs.getString("Username"));
	            usuario.setPassword(rs.getString("Password"));
	            usuario.setRol(rs.getBoolean("Rol"));
	            usuario.setCorreoElectronico(rs.getString("CorreoElectronico"));
	            usuario.setActivo(rs.getBoolean("Activo"));
	            // Otros campos de la entidad

	            usuarios.add(usuario);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null)
	                rs.close();
	            if (pstm != null)
	                pstm.close();
	            if (cn != null)
	                cn.close();
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
	    return usuarios;
	}
	@Override
	public Usuarios iniciarSesion(String login) {
		 Usuarios usuario = null;
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;

		    try {
		        conn = new MySqlConectar().getConectar(); 
		        String sql = "SELECT UsuarioID, CorreoElectronico, Nombre, Rol, Password, Username,Activo, salt FROM usuarios WHERE CorreoElectronico = ?";
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, login);
		        rs = pstmt.executeQuery();
		        if (rs.next()) {
		        	usuario = new Usuarios();
			            usuario.setUsuarioID(rs.getInt("UsuarioID"));
			            usuario.setNombre(rs.getString("Nombre"));
			            usuario.setCorreoElectronico(rs.getString("CorreoElectronico"));
			            usuario.setUsername(rs.getString("Username"));
			            usuario.setPassword(rs.getString("Password"));
			            usuario.setRol(rs.getBoolean("Rol"));
			            usuario.setActivo(rs.getBoolean("Activo"));
			        byte[] salt = rs.getBytes("salt"); // Obtener el salt como un arreglo de bytes
			        usuario.setSalt(salt);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return usuario;
	}

}
