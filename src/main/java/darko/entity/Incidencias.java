package darko.entity;

import java.time.LocalDateTime;

public class Incidencias {
	private int IncidenciaID;
	private int ProductoID;
	private String Estado;
	private LocalDateTime FechaRegistro;
	private LocalDateTime FechaSolucion;
	private String DescripcionIncidencia;
	public int getIncidenciaID() {
		return IncidenciaID;
	}
	public void setIncidenciaID(int incidenciaID) {
		IncidenciaID = incidenciaID;
	}
	public int getProductoID() {
		return ProductoID;
	}
	public void setProductoID(int productoID) {
		ProductoID = productoID;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public LocalDateTime getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	public LocalDateTime getFechaSolucion() {
		return FechaSolucion;
	}
	public void setFechaSolucion(LocalDateTime fechaSolucion) {
		FechaSolucion = fechaSolucion;
	}
	public String getDescripcionIncidencia() {
		return DescripcionIncidencia;
	}
	public void setDescripcionIncidencia(String descripcionIncidencia) {
		DescripcionIncidencia = descripcionIncidencia;
	}
	
}
