package darko.interfaces;

import java.util.List;

import darko.entity.Inventario;

public interface InventarioDAO {
	int save(Inventario bean);
	//método que actualiza un EVENTO y retorna un entero
	int update(Inventario bean);
	//método deleteById que elimina un EVENTOS según su código  y retorna un entero
	int deleteById(int cod);
	//método findById busca código de un EVENTOS y retorna un objeto VOLUNTARIO
	Inventario findById(int cod);
	//Lista EVENTOS
public List<Inventario> findAll();
}
