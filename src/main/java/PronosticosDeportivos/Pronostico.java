package PronosticosDeportivos;



public class Pronostico {
	private int numeroPro;
	private String participante;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private String resLocal;
	private String resVisitante;
	private String combinaRes;
	private int ronda;
		

	//Constructors
	public Pronostico() {			
	}
	
	public Pronostico(int numeroPro, String participante, Equipo equipoLocal, Equipo equipoVisitante, String resLocal, String resVisitante,
			String combinaRes, int ronda) {
		this();
		this.numeroPro = numeroPro;
		this.participante = participante;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.resLocal = resLocal;
		this.resVisitante = resVisitante;
		this.combinaRes = combinaRes;
		this.ronda = ronda;
	}

	//Getters y Setters
	
	public int getRonda() {
		return ronda;
	}

	public void setRonda(int ronda) {
		this.ronda = ronda;
	}

	public int getNumeroPro() {
		return numeroPro;
	}
	public void setNumeroPro(int numeroPro) {
		this.numeroPro = numeroPro;
	}
	public String getParticipante() {
		return participante;
	}
	
	public Equipo getEquipoLocal() {
		return equipoLocal;
	}
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}
	public String getResLocal() {
		return resLocal;
	}
	public String getResVisitante() {
		return resVisitante;
	}
	public String getCombinaRes() {
		return combinaRes;
	}
	public void setParticipante(String participante) {
		this.participante = participante;
	}
	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	public void setResLocal(String resLocal) {
		this.resLocal = resLocal;
	}
	public void setResVisitante(String resVisitante) {
		this.resVisitante = resVisitante;
	}
	public void setConvinaRes(String combinaRes) {
		this.combinaRes = combinaRes;
	}

	/*private Resultado resultado;
	private String resultadoPronosticado; //G E P
	private Equipo equipoSeleccionado;
	
	public Resultado getResultado() {
		return resultado;
	}
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	public String getResultadoPronosticado() {
		return resultadoPronosticado;
	}
	public void setResultadoPronosticado(String resultadoPronosticado) {
		this.resultadoPronosticado = resultadoPronosticado;
	}
	public Equipo getEquipoSeleccionado() {
		return equipoSeleccionado;
	}
	public void setEquipoSeleccionado(Equipo equipoSeleccionado) {
		this.equipoSeleccionado = equipoSeleccionado;
	}
	
	public int puntos() {
		String nombreEquipoLocal = this.resultado.getEquipoLocal().getNombre();
		String nombreEquipovisitante = this.resultado.getEquipoVisitante().getNombre();
		String resultado= this.resultadoPronosticado;
		String nombreEquipoSeleccionado = this.equipoSeleccionado.getNombre();
		int golesEquipoLocal = this.resultado.getGolesLocal();
		int golesEquipoVisitante = this.resultado.getGolesVisitante();
		
		if(resultado == "G" && golesEquipoLocal > golesEquipoVisitante && nombreEquipoLocal==nombreEquipoSeleccionado) {
				this.jugador.sumarPuntos(1);
				return 1;			
		}
		if(resultado == "P" && golesEquipoLocal < golesEquipoVisitante && nombreEquipoLocal==nombreEquipoSeleccionado) {
			this.jugador.sumarPuntos(1);
			return 1;		
		}
		if(resultado == "E" && golesEquipoLocal == golesEquipoVisitante) {
			this.jugador.sumarPuntos(1);
			return 1;		
		}		
		return 0;
	}*/
	
}



