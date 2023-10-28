package darko.entity;

public class Diccionario {
	private int FallaID;
	private String DescripcionFalla;
	private String SolucionFalla;
	public int getFallaID() {
		return FallaID;
	}
	public void setFallaID(int fallaID) {
		FallaID = fallaID;
	}
	public String getDescripcionFalla() {
		return DescripcionFalla;
	}
	public void setDescripcionFalla(String descripcionFalla) {
		DescripcionFalla = descripcionFalla;
	}
	public String getSolucionFalla() {
		return SolucionFalla;
	}
	public void setSolucionFalla(String solucionFalla) {
		SolucionFalla = solucionFalla;
	}
}
