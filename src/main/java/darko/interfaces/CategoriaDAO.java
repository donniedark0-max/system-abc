package darko.interfaces;

import java.util.List;

import darko.entity.Categoria;


public interface CategoriaDAO {
	int save(Categoria bean);
	//método que actualiza un EVENTO y retorna un entero
	int update(Categoria bean);
	//método deleteById que elimina un EVENTOS según su código  y retorna un entero
	int deleteById(int cod);
	//método findById busca código de un EVENTOS y retorna un objeto VOLUNTARIO
	Categoria findById(int cod);
	//Lista EVENTOS
public List<Categoria> findAll();
}
