package darko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import darko.entity.Categoria;
import darko.interfaces.CategoriaDAO;
import darko.utils.MySqlConectar;

public class MySqlCategoriaDAO implements CategoriaDAO {

	@Override
	public int save(Categoria bean) {
		  int resultado = -1;
	        Connection cn = null;
	        PreparedStatement pstm = null;
	        
	        try {
	            cn = new MySqlConectar().getConectar();
	            String sql = "INSERT INTO Categorias (Nombre, Descripcion) VALUES (?, ?)";
	            pstm = cn.prepareStatement(sql);
	            pstm.setString(1, bean.getNombre());
	            pstm.setString(2, bean.getDescripcion());
	            
	            resultado = pstm.executeUpdate();
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
	        
	        return resultado;
	}

	@Override
	public int update(Categoria bean) {
		 int resultado = -1;
	        Connection cn = null;
	        PreparedStatement pstm = null;
	        
	        try {
	            cn = new MySqlConectar().getConectar();
	            String sql = "UPDATE Categorias SET Nombre = ?, Descripcion = ? WHERE CategoriaID = ?";
	            pstm = cn.prepareStatement(sql);
	            pstm.setString(1, bean.getNombre());
	            pstm.setString(2, bean.getDescripcion());
	            pstm.setInt(3, bean.getCategoriaID());
	            
	            resultado = pstm.executeUpdate();
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
	        
	        return resultado;
	}

	@Override
	public int deleteById(int cod) {
		  int resultado = -1;
	        Connection cn = null;
	        PreparedStatement pstm = null;
	        
	        try {
	            cn = new MySqlConectar().getConectar();
	            String sql = "DELETE FROM Categorias WHERE CategoriaID = ?";
	            pstm = cn.prepareStatement(sql);
	            pstm.setInt(1, cod);
	            
	            resultado = pstm.executeUpdate();
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
	        
	        return resultado;
	}

	@Override
	public Categoria findById(int cod) {
		  Categoria categoria = null;
	        Connection cn = null;
	        PreparedStatement pstm = null;
	        ResultSet rs = null;
	        
	        try {
	            cn = new MySqlConectar().getConectar();
	            String sql = "SELECT * FROM Categorias WHERE CategoriaID = ?";
	            pstm = cn.prepareStatement(sql);
	            pstm.setInt(1, cod);
	            rs = pstm.executeQuery();
	            
	            if (rs.next()) {
	                categoria = new Categoria();
	                categoria.setCategoriaID(rs.getInt("CategoriaID"));
	                categoria.setNombre(rs.getString("Nombre"));
	                categoria.setDescripcion(rs.getString("Descripcion"));
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
	        
	        return categoria;
	}

	@Override
	public List<Categoria> findAll() {
		   List<Categoria> categorias = new ArrayList<>();
	        Connection cn = null;
	        PreparedStatement pstm = null;
	        ResultSet rs = null;
	        
	        try {
	            cn = new MySqlConectar().getConectar();
	            String sql = "SELECT * FROM Categorias";
	            pstm = cn.prepareStatement(sql);
	            rs = pstm.executeQuery();
	            
	            while (rs.next()) {
	                Categoria categoria = new Categoria();
	                categoria.setCategoriaID(rs.getInt("CategoriaID"));
	                categoria.setNombre(rs.getString("Nombre"));
	                categoria.setDescripcion(rs.getString("Descripcion"));
	                // Puedes asignar otros campos de la entidad de manera similar
	                categorias.add(categoria);
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
	        
	        return categorias;
	    }

}
