package darko.interfaces;

import java.util.List;

import darko.entity.Reportes;


public interface ReportesDAO {
	int save(Reportes bean);
	//método que actualiza un EVENTO y retorna un entero
	int update(Reportes bean);
	//método deleteById que elimina un EVENTOS según su código  y retorna un entero
	int deleteById(int cod);
	//método findById busca código de un EVENTOS y retorna un objeto VOLUNTARIO
	Reportes findById(int cod);
	//Lista EVENTOS
public List<Reportes> findAll();
}
