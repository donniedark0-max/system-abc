package darko.interfaces;

import java.util.List;

import darko.entity.Usuarios;


public interface UsuariosDAO {
	int save(Usuarios bean);
	//método que actualiza un EVENTO y retorna un entero
	int update(Usuarios bean);
	//método deleteById que elimina un EVENTOS según su código  y retorna un entero
	int deleteById(int cod);
	//método findById busca código de un EVENTOS y retorna un objeto VOLUNTARIO
	Usuarios findById(int cod);
	//Lista EV0ENTOS
public List<Usuarios> findAll();
Usuarios iniciarSesion(String login);

}
