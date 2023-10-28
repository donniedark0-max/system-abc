package darko.interfaces;

import java.util.List;

import darko.entity.Diccionario;


public interface DiccionarioDAO {
	int save(Diccionario bean);
	//método que actualiza un EVENTO y retorna un entero
	int update(Diccionario bean);
	//método deleteById que elimina un EVENTOS según su código  y retorna un entero
	int deleteById(int cod);
	//método findById busca código de un EVENTOS y retorna un objeto VOLUNTARIO
	Diccionario findById(int cod);
	//Lista EVENTOS
public List<Diccionario> findAll();
}
