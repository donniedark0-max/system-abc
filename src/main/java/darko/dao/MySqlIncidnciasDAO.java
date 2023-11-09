package darko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import darko.entity.Incidencias;
import darko.interfaces.IncidenciasDAO;
import darko.utils.MySqlConectar;

public class MySqlIncidnciasDAO implements IncidenciasDAO{

	@Override
	public int save(Incidencias bean) {
		int salida = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    try {
	        cn = new MySqlConectar().getConectar();
	        String sql = "INSERT INTO incidencias ( ProductoID, DescripcionIncidencia) VALUES (?,?)";
	        pstm = cn.prepareStatement(sql);
	        pstm.setInt(1, bean.getProductoID());
	        pstm.setString(2, bean.getDescripcionIncidencia());
	      
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
	public int update(Incidencias bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int cod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Incidencias findById(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Incidencias> findAll() {
		 List<Incidencias> incidencias = new ArrayList<>();
	        Connection cn = null;
	        PreparedStatement pstm = null;
	        ResultSet rs = null;

	        try {
	        	 cn = new MySqlConectar().getConectar();
	        	    String sql = "SELECT * FROM incidencias";
	        	    pstm = cn.prepareStatement(sql);
	        	    rs = pstm.executeQuery();

	        	    while (rs.next()) {
	        	        Incidencias incidencia = new Incidencias();
	        	        incidencia.setIncidenciaID(rs.getInt("IncidenciaID"));
	        	        incidencia.setProductoID(rs.getInt("ProductoID"));
	        	        incidencia.setEstado(rs.getString("Estado"));
	        	        incidencia.setFechaRegistro(rs.getTimestamp("FechaRegistro"));
	        	        incidencia.setFechaSolucion(rs.getTimestamp("FechaSolucion"));
	        	        incidencia.setDescripcionIncidencia(rs.getString("DescripcionIncidencia")); 
	        	        incidencias.add(incidencia);
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

	        return incidencias;
	}

}
