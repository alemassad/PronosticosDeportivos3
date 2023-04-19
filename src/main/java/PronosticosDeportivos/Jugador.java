package PronosticosDeportivos;

public class Jugador {
	//Propiedodes
	private String nombre;
	private int puntos;
	//Constructor
	public Jugador() {
		this.puntos = 0;
	}
	public Jugador(String nombre) {
		this();
		this.nombre = nombre;
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	} 
	
	public int getPuntos() {
		return puntos;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	//Metodos
	public void sumarPuntos(int puntos) {
		this.puntos = this.puntos + puntos;
	}
}
