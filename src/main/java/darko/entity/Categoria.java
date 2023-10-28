package darko.entity;

public class Categoria {
	private int CategoriaID;
	private String Nombre;
	private String Descripcion;
	public int getCategoriaID() {
		return CategoriaID;
	}
	public void setCategoriaID(int categoriaID) {
		CategoriaID = categoriaID;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
}
