package darko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import darko.entity.Productos;
import darko.interfaces.ProductosDAO;
import darko.utils.MySqlConectar;

public class MySqlProductosDAO implements ProductosDAO{

	@Override
	public int save(Productos bean) {
		  int resultado = -1;
	        Connection cn = null;
	        PreparedStatement pstm = null;

	        try {
	            cn = new MySqlConectar().getConectar();
	            String sql = "INSERT INTO Productos (Nombre, Codigo, Descripcion, CategoriaID, PrecioUnitario, CantidadEnStock) VALUES (?, ?, ?, ?, ?, ?)";
	            pstm = cn.prepareStatement(sql);
	            pstm.setString(1, bean.getNombre());
	            pstm.setString(2, bean.getCodigo());
	            pstm.setString(3, bean.getDescripcion());
	            pstm.setInt(4, bean.getCategoriaID());
	            pstm.setDouble(5, bean.getPrecioUnitario());
	            pstm.setInt(6, bean.getCantidadEnStock());

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
	public int update(Productos bean) {
        int resultado = -1;
		 Connection cn = null;
	        PreparedStatement pstm = null;

	        try {
	            cn = new MySqlConectar().getConectar();
	            String sql = "UPDATE Productos SET Nombre = ?, Codigo = ?, Descripcion = ?, CategoriaID = ?, PrecioUnitario = ?, CantidadEnStock = ? WHERE ProductoID = ?";
	            pstm = cn.prepareStatement(sql);
	            pstm.setString(1, bean.getNombre());
	            pstm.setString(2, bean.getCodigo());
	            pstm.setString(3, bean.getDescripcion());
	            pstm.setInt(4, bean.getCategoriaID());
	            pstm.setDouble(5, bean.getPrecioUnitario());
	            pstm.setInt(6, bean.getCantidadEnStock());
	            pstm.setInt(7, bean.getProductoID());

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
	            String sql = "DELETE FROM Productos WHERE ProductoID = ?";
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
	public Productos findById(int cod) {
		  Productos producto = null;
	        Connection cn = null;
	        PreparedStatement pstm = null;
	        ResultSet rs = null;

	        try {
	            cn = new MySqlConectar().getConectar();
	            String sql = "SELECT * FROM Productos WHERE ProductoID = ?";
	            pstm = cn.prepareStatement(sql);
	            pstm.setInt(1, cod);
	            rs = pstm.executeQuery();

	            if (rs.next()) {
	                producto = new Productos();
	                producto.setProductoID(rs.getInt("ProductoID"));
	                producto.setNombre(rs.getString("Nombre"));
	                producto.setCodigo(rs.getString("Codigo"));
	                producto.setDescripcion(rs.getString("Descripcion"));
	                producto.setCategoriaID(rs.getInt("CategoriaID"));
	                producto.setPrecioUnitario(rs.getDouble("PrecioUnitario"));
	                producto.setCantidadEnStock(rs.getInt("CantidadEnStock"));
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

	        return producto;
	}

	@Override
	public List<Productos> findAll() {
		  List<Productos> productos = new ArrayList<>();
	        Connection cn = null;
	        PreparedStatement pstm = null;
	        ResultSet rs = null;

	        try {
	        	 cn = new MySqlConectar().getConectar();
	        	    String sql = "SELECT p.*, c.Nombre AS CategoriaNombre FROM productos p "
	        	               + "INNER JOIN categorias c ON p.CategoriaID = c.CategoriaID";
	        	    pstm = cn.prepareStatement(sql);
	        	    rs = pstm.executeQuery();

	        	    while (rs.next()) {
	        	        Productos producto = new Productos();
	        	        producto.setProductoID(rs.getInt("ProductoID"));
	        	        producto.setNombre(rs.getString("Nombre"));
	        	        producto.setCodigo(rs.getString("Codigo"));
	        	        producto.setDescripcion(rs.getString("Descripcion"));
	        	        producto.setCategoriaID(rs.getInt("CategoriaID"));
	        	        producto.setNombre_Categoria(rs.getString("CategoriaNombre")); // Nombre de la categoría
	        	        producto.setPrecioUnitario(rs.getDouble("PrecioUnitario"));
	        	        producto.setCantidadEnStock(rs.getInt("CantidadEnStock"));
	        	        // Puedes asignar otros campos de la entidad de manera similar
	        	        productos.add(producto);
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

	        return productos;
	    
	}


	@Override
	public int deleteByCattId(int cod) {
		int result = -1;
	    Connection con = null;
	    PreparedStatement ps = null;

	    try {
	        con = new MySqlConectar().getConectar();
	        // Deshabilitar el autocommit para iniciar una transacción
	        con.setAutoCommit(false);

	        // Antes de eliminar voluntarios, eliminar las inscripciones relacionadas

	  
	            // Si se eliminaron las inscripciones correctamente, eliminar los voluntarios
	            String sql = "DELETE FROM productos WHERE CategoriaID= ?";
	            ps = con.prepareStatement(sql);
	            ps.setInt(1, cod);
	            result = ps.executeUpdate();
	    
	        // Confirmar la transacción
	        con.commit();
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
	            if (ps != null)
	                ps.close();
	            if (con != null) {
	                // Restablecer el autocommit
	                con.setAutoCommit(true);
	                con.close();
	            }
	        } catch (SQLException e2) {
	            e2.printStackTrace();
	        }
	    }

	    return result;
	}

	@Override
	public int updateCat(Productos producto, String categoria) {
		 int resultado = -1;
		    Connection cn = null;
		    PreparedStatement pstm = null;
		    try {
		        cn = new MySqlConectar().getConectar();

		        int categoriaID = 0; // Valor predeterminado para la categoría C
		        if (categoria.equals("A")) {
		            categoriaID = 1;
		        } else if (categoria.equals("B")) {
		            categoriaID = 2;
		        }

		        String sql = "UPDATE Productos SET CategoriaID = ? WHERE Codigo = ?";
		        pstm = cn.prepareStatement(sql);
		        pstm.setInt(1, categoriaID);
		        pstm.setString(2, producto.getCodigo());

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

}
