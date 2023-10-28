package darko.interfaces;

import java.util.List;

import darko.entity.Incidencias;


public interface IncidenciasDAO {
	int save(Incidencias bean);
	//método que actualiza un EVENTO y retorna un entero
	int update(Incidencias bean);
	//método deleteById que elimina un EVENTOS según su código  y retorna un entero
	int deleteById(int cod);
	//método findById busca código de un EVENTOS y retorna un objeto VOLUNTARIO
	Incidencias findById(int cod);
	//Lista EVENTOS
public List<Incidencias> findAll();
}
