package darko.entity;

public class Productos {
	private int ProductoID;
	private String Nombre;
	private String Codigo;
	private String Descripcion;
	private int CategoriaID;
	private double PrecioUnitario;
	private int CantidadEnStock;
	private String Nombre_Categoria;
	public String getNombre_Categoria() {
		return Nombre_Categoria;
	}
	public void setNombre_Categoria(String nombre_Categoria) {
		Nombre_Categoria = nombre_Categoria;
	}
	public int getProductoID() {
		return ProductoID;
	}
	public void setProductoID(int productoID) {
		ProductoID = productoID;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getCategoriaID() {
		return CategoriaID;
	}
	public void setCategoriaID(int categoriaID) {
		CategoriaID = categoriaID;
	}
	public double getPrecioUnitario() {
		return PrecioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		PrecioUnitario = precioUnitario;
	}
	public int getCantidadEnStock() {
		return CantidadEnStock;
	}
	public void setCantidadEnStock(int cantidadEnStock) {
		CantidadEnStock = cantidadEnStock;
	}
	
}
