package darko.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Incidencias {
	private int IncidenciaID;
	private int ProductoID;
	private String Estado;
	private Timestamp FechaRegistro;
	private Timestamp FechaSolucion;
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
	public Timestamp getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(Timestamp timestamp) {
		FechaRegistro = timestamp;
	}
	public Timestamp getFechaSolucion() {
		return FechaSolucion;
	}
	public void setFechaSolucion(Timestamp fechaSolucion) {
		FechaSolucion = fechaSolucion;
	}
	public String getDescripcionIncidencia() {
		return DescripcionIncidencia;
	}
	public void setDescripcionIncidencia(String descripcionIncidencia) {
		DescripcionIncidencia = descripcionIncidencia;
	}
	
}
