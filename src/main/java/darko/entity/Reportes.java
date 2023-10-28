package darko.entity;

import java.sql.Date;

public class Reportes {
	private int ReporteID;
	private String NombreReporte;
	private Date FechaCreacion;
	private String Contenido;
	private int UsuarioID;
	public int getReporteID() {
		return ReporteID;
	}
	public void setReporteID(int reporteID) {
		ReporteID = reporteID;
	}
	public String getNombreReporte() {
		return NombreReporte;
	}
	public void setNombreReporte(String nombreReporte) {
		NombreReporte = nombreReporte;
	}
	public Date getFechaCreacion() {
		return FechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}
	public String getContenido() {
		return Contenido;
	}
	public void setContenido(String contenido) {
		Contenido = contenido;
	}
	public int getUsuarioID() {
		return UsuarioID;
	}
	public void setUsuarioID(int usuarioID) {
		UsuarioID = usuarioID;
	}
	
}
