package PronosticosDeportivos;

import java.util.ArrayList;
import java.util.List;

public class Resultado {
	private int numeroPartido;	
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private int golesLocal;
	private int golesVisitante;
	private String combinaRes;
	private int ronda;
	
	private List<Pronostico> pronosticos;
	
	//Getters y setters
	public int getRonda() {
		return ronda;
	}
	public void setRonda(int ronda) {
		this.ronda = ronda;
		}
	public int getNumeroPartido() {
		return numeroPartido;
	}
	public void setNumeroPartido(int numeroPartido) {
		this.numeroPartido = numeroPartido;
	}
	public Equipo getEquipoLocal() {
		return equipoLocal;
	}
	public String getConvinaRes() {
		return combinaRes;
	}
	public void setCombinaRes(String combinaRes) {
		this.combinaRes = combinaRes;
	}
	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	public int getGolesLocal() {
		return golesLocal;
	}
	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}
	public int getGolesVisitante() {
		return golesVisitante;
	}
	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
	public List<Pronostico> getPronosticos() {
		return pronosticos;
	}
	
	//Constructores
	
	public Resultado() {
		pronosticos = new ArrayList<>();		
	}
	public Resultado(int numeroPartido, Equipo equipoLocal, Equipo equipoVisitante, int golesLocal, int golesVisitante,
			String combinaRes) {
		this();
		this.numeroPartido = numeroPartido;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.combinaRes = combinaRes;
	}
	public void agregarPronostico(List<Pronostico> resultaList) {
		pronosticos.addAll(resultaList);		
	}
	
	
	
	
}
