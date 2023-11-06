package darko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import darko.entity.Diccionario;
import darko.interfaces.DiccionarioDAO;
import darko.utils.MySqlConectar;

public class MySqlDiccionarioDAO implements DiccionarioDAO{

	@Override
	public int save(Diccionario bean) {
		int salida = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    try {
	        cn = new MySqlConectar().getConectar();
	        String sql = "INSERT INTO diccionariofallas( DescripcionFalla, SolucionFalla) VALUES (?,?)";
	        pstm = cn.prepareStatement(sql);
	        pstm.setString(1, bean.getDescripcionFalla());
	        pstm.setString(2, "En Espera");
	      
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
	public int update(Diccionario bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int cod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Diccionario findById(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Diccionario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
