package PronosticosDeportivos;

import java.util.ArrayList;
import java.util.List;

public class Puntos {
	
	private List<Pronostico> pronoList;
	private List<Resultado> resultaList;
	
	//Constructor
	public Puntos(List<Pronostico> pronoList, List<Resultado> resultaList) {
		
		this.pronoList = pronoList;
		this.resultaList = resultaList;
	}

	//Getters y Setters
	public List<Pronostico> getPronoList() {
		return pronoList;
	}

	public List<Resultado> getResultaList() {
		return resultaList;
	}
	public void setPronoList(List<Pronostico> pronoList) {
		this.pronoList = pronoList;
	}
	public void setResultaList(List<Resultado> resultaList) {
		this.resultaList = resultaList;
	}
	public String puntaje() {

		//List<Pronostico> pronoList = puntoClass.getPronoList();
		//List<Resultado> resultaList = puntoClass.getResultaList();
		int puntaje = 0;
		int puntaje2 = 0;
		
		
		String particiPunto1 = null;
		String particiPunto2 = null;
		String ronda = null;
		
			// Comparamos los Resultados con los Pronosticos para asignar puntaje
			for (int i=0; i < pronoList.size(); i ++) {
		           
		            for (Resultado re : resultaList) {
		                    if (pronoList.get(i).getCombinaRes().equals(re.getConvinaRes())) {//Si la Clave convinada del Pronóstico es = a la Clave del Resultado
		                    	
		                        if(pronoList.get(i).getNumeroPro()==re.getNumeroPartido()) { // y Si el número de Pronóstico es = al número del partido
		                        	
		                        	puntaje ++;
		                        	particiPunto1=pronoList.get(i).getParticipante();
		                        }
		                        if((pronoList.get(i).getNumeroPro())==re.getNumeroPartido()+4) { // Si el número de Pronóstico es = al número del partido + 4(porque son 4 resultados contra 8 pronosticos)
			                    	
			                        puntaje2 ++;
			                        particiPunto2= pronoList.get(i).getParticipante();
			                       }
		                    } 
		            }	      
		           
		      }	
					
			if((puntaje == 1 || puntaje == 0) & (particiPunto1 != null)) {// Verificamos si el resultado es plural o singular para mostrarlo
				System.out.println ("Acierto de "+particiPunto1+": "+puntaje+ " punto");
			}else {
				System.out.println ("Aciertos de "+particiPunto1+": "+puntaje+ " puntos ");
			}
			if((puntaje2 == 1 || puntaje2 == 0) & (particiPunto2  != null)) {// Verificamos si el resultado es plural o singular para mostrarlo
				 System.out.println("Acierto de "+particiPunto2+": "+puntaje2+ " punto");
			}else {
				System.out.println("Aciertos de "+particiPunto2+": "+puntaje2+ " puntos ");
			}
			
		
		
		return "sin Puntaje";
	}

}
