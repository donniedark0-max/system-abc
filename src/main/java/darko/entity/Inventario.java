package darko.entity;

public class Inventario {
	private int InventarioID;
	private int ProductoID;
	private int Cantidad;
	private double ValorTotal;
	public int getInventarioID() {
		return InventarioID;
	}
	public void setInventarioID(int inventarioID) {
		InventarioID = inventarioID;
	}
	public int getProductoID() {
		return ProductoID;
	}
	public void setProductoID(int productoID) {
		ProductoID = productoID;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public double getValorTotal() {
		return ValorTotal;
	}
	public void setValorTotal(double valorTotal) {
		ValorTotal = valorTotal;
	}
	
}
