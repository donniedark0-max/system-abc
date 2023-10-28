package darko.interfaces;

import java.util.List;

import darko.entity.Productos;


public interface ProductosDAO {
	int save(Productos bean);
	//método que actualiza un EVENTO y retorna un entero
	int update(Productos bean);
	//método deleteById que elimina un EVENTOS según su código  y retorna un entero
	int deleteById(int cod);
	//método findById busca código de un EVENTOS y retorna un objeto VOLUNTARIO
	Productos findById(int cod);
	//Lista EVENTOS
public List<Productos> findAll();
int deleteByCattId(int cod);

int updateCat( Productos producto, String categoria);

}
