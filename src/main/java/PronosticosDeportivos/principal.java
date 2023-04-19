package PronosticosDeportivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Conexion.ConectorSQL.DB_URL;
import static Conexion.ConectorSQL.USER;
import static Conexion.ConectorSQL.PASS;

public class principal {
	List<Pronostico> pronoList = new ArrayList<Pronostico>();
	
	public static void main(String[] args) {
		Connection conexion = null;
		Statement consulta = null;

		try {
			// Abrimos la conexión
			System.out.println("conectando a la base de datos...");

			conexion = DriverManager.getConnection(DB_URL, USER, PASS);

			// Ejecutamos una consulta de pronosticos
			System.out.println("Creando statement de Pronósticos...");
			System.out.println("===================================");
			consulta = conexion.createStatement();
			String sql;
			sql = "SELECT * FROM prode_db.pronosticos";

			// En la variable resultado obtendremos las distintas filas que nos devolvió la base
			ResultSet resultado = consulta.executeQuery(sql);

			// Obtenemos las distintas filas de la consulta
			while (resultado.next()) {

				// Obtenemos el valor de cada columna
				int id = resultado.getInt("numeroPro");
				String nombre = resultado.getString("participante");
				String equipoLocal = resultado.getString("equipoLocal");
				String valorLocal = resultado.getString("valorLocal");
				String valorEmpate = resultado.getString("valorEmpate");
				String valorVisitante = resultado.getString("valorVisitante");
				String equipoVisitante = resultado.getString("equipoVisitante");
				int ronda = resultado.getInt("ronda");

				// Llamamos a la funcion pronosticos y pasamos parámetros para asignar los datos
				
				leerPronosticos(id, nombre, equipoLocal, valorLocal, valorEmpate, valorVisitante, equipoVisitante,
						ronda);

				// ==============================================================================
			}
			// Cerramos la consulta a la base de datos
			resultado.close();
			consulta.close();

			// -----------------------consultamos resultados

			System.out.println("Creando statement de Resultados...");
			System.out.println("===================================");
			consulta = conexion.createStatement();

			sql = "SELECT * FROM prode_db.partidos";

			// En la variable resultado obtendremos las distintas filas que nos devolvió la base
			resultado = consulta.executeQuery(sql);

			// Obtenemos las distintas filas de la consulta
			while (resultado.next()) {

				// Obtenemos el valor de cada columna
				int id = resultado.getInt("idPartido");
				String equipoLocal = resultado.getString("equipoLocal");
				String golesLocal = resultado.getString("golesLocal");
				String golesVisitante = resultado.getString("golesVisitante");
				String equipoVisitante = resultado.getString("equipoVisitante");
				int ronda = resultado.getInt("ronda");
				
				//Llamamos a la funcion LeerResultados para asignar los datos
				
				leerResultados(id, equipoLocal, golesLocal, golesVisitante, equipoVisitante, ronda);
				
			}
			
			// Cerramos la conexión con la base de datos
			resultado.close();
			consulta.close();

			conexion.close();
			System.out.println("===================================");
			System.out.println("Cerrando la base de datos...");
		} catch (SQLException se) {
			// Execpción ante problemas de conexión
			se.printStackTrace();
		} finally {
			// Esta sentencia es para que ante un problema con la base igual se cierren las
			// conexiones
			try {
				if (consulta != null)
					consulta.close();
			} catch (SQLException se2) {
			}
			try {
				if (conexion != null)
					conexion.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		System.out.println("GAME OVER");
		
	}

	private static void leerResultados(int id, String equipoLocal, String golesLocal, String golesVisitante,
			String equipoVisitante, int ronda2) {
		
		
		int ronda = 0;
		String resultado1 = "0";
		String resultado2 = "0";
		String equipo1 = "";
		String equipo2 = "";
		
		String resp1 = "";
		List<Resultado> resultaList = new ArrayList<>();
		
		System.out.println();
		System.out.println(" PARTIDO  " + id);

		ronda = ronda2;
		equipo1 = equipoLocal;
		resultado1 = golesLocal;
		resultado2 = golesVisitante;
		equipo2 = equipoVisitante;

		int resul1 = Integer.parseInt(resultado1); // Pasamos los resultados a Enteros
		int resul2 = Integer.parseInt(resultado2); // para despues poder compararlos
		Resultado resulta = new Resultado();
		Equipo equiLocal = new Equipo();
		Equipo equiVisitante = new Equipo();

		equiLocal.setNombre(equipo1);
		equiVisitante.setNombre(equipo2);
		resulta.setNumeroPartido(id);
		resulta.setEquipoLocal(equiLocal);
		resulta.setEquipoVisitante(equiVisitante);
		resulta.setGolesLocal(resul1);
		resulta.setGolesVisitante(resul2);
		resulta.setRonda(ronda);

		System.out.println("Ronda nº " + ronda + " ==> Equipo1 : " + resulta.getEquipoLocal().getNombre() + " => "
				+ resulta.getGolesLocal());
		System.out.println("Ronda nº " + ronda + " ==> Equipo2 : " + resulta.getEquipoVisitante().getNombre() + " => "
				+ resulta.getGolesVisitante());

		if (resul1 > resul2) {
			resultado1 = "G";
			resultado2 = "P";
			System.out.println(equipo1 + " " + resultado1);
			System.out.println(equipo2 + " " + resultado2);
			resp1 = resultado1 + resultado2;
			resulta.setCombinaRes(resp1);
			System.out.println("Clave=> " + resp1);

		} else if (resul1 < resul2) {
			resultado1 = "P";
			resultado2 = "G";
			System.out.println(equipo1 + " " + resultado1);
			System.out.println(equipo2 + " " + resultado2);
			resp1 = resultado1 + resultado2;
			resulta.setCombinaRes(resp1);
			System.out.println("Clave=> " + resp1);
		} else {
			resultado1 = "E";
			resultado2 = "E";
			System.out.println(equipo1 + " " + resultado1);
			System.out.println(equipo2 + " " + resultado2);
			resp1 = resultado1 + resultado2;
			System.out.println("Clave=> " + resp1);
			resulta.setCombinaRes(resp1);
		}

		resultaList.add(resulta);
		Puntos puntos = new Puntos(null, resultaList);
		puntos.setResultaList(resultaList);

		
	}

	private static void leerPronosticos(int id, String nombre, String equipoLocal, String valorLocal,
			String valorEmpate, String valorVisitante, String equipoVisitante, int ronda2) {

		
		String participante = null;
	
		int i = 0;
		String equipo1 = null;
		String equipo2 = null;
		String tipoPronostico1 = "", tipoPronostico2 = "";
		String[] prono1 = new String[2];
		String[] prono2 = new String[2];
		String[] prono3 = new String[2];
		String[] prono4 = new String[2];
		String[] prono5 = new String[2];
		String[] prono6 = new String[2];
		String[] prono7 = new String[2];
		String[] prono8 = new String[2];

		List<Pronostico> pronoList = new ArrayList<Pronostico>();

		System.out.println();
		System.out.println(" PRONOSTICO " + id);

		participante = nombre;
		equipo1 = equipoLocal;
		if (valorLocal.contains("1")) {
			tipoPronostico1 = "G";
			tipoPronostico2 = "P";
		}
		if (valorEmpate.contains("1")) {
			tipoPronostico1 = "E";
			tipoPronostico2 = "E";
		}
		if (valorVisitante.contains("1")) {
			tipoPronostico1 = "P";
			tipoPronostico2 = "G";
		}
		equipo2 = equipoVisitante;

		Equipo equiLocal = new Equipo();
		Equipo equiVisitante = new Equipo();
		Pronostico pronosti = new Pronostico();

		equiLocal.setNombre(equipo1);
		equiVisitante.setNombre(equipo2);
		pronosti.setNumeroPro(id);
		pronosti.setEquipoLocal(equiLocal);
		pronosti.setEquipoVisitante(equiVisitante);
		pronosti.setResLocal(tipoPronostico1);
		pronosti.setResVisitante(tipoPronostico2);
		pronosti.setRonda(ronda2);

		System.out.println("Participante: " + participante + " ↔ Equipo1 : " + equipo1 + " => " + tipoPronostico1);

		System.out.println("Participante: " + participante + " ↔ Equipo2 : " + equipo2 + " => " + tipoPronostico2);

		if (i == 0) {
			prono1[0] = tipoPronostico1 + tipoPronostico2;// Combinamos los resultados para sacar una CLAVE
			prono1[1] = participante;
			i++;
			pronosti.setConvinaRes(prono1[0]);
			pronosti.setParticipante(prono1[1]);
			System.out.println(pronosti.getParticipante() + " Clave=> " + pronosti.getCombinaRes());
			pronoList.add(pronosti);
		} else if (i == 1) {
			prono2[0] = tipoPronostico1 + tipoPronostico2;
			prono2[1] = participante;
			i++;
			pronosti.setConvinaRes(prono2[0]);
			pronosti.setParticipante(prono2[1]);
			System.out.println(pronosti.getParticipante() + " Clave=> " + pronosti.getCombinaRes());
			pronoList.add(pronosti);
		} else if (i == 2) {
			prono3[0] = tipoPronostico1 + tipoPronostico2;
			prono3[1] = participante;
			i++;
			pronosti.setConvinaRes(prono3[0]);
			pronosti.setParticipante(prono3[1]);
			System.out.println(pronosti.getParticipante() + " Clave=> " + pronosti.getCombinaRes());
			pronoList.add(pronosti);
		} else if (i == 3) {
			prono4[0] = tipoPronostico1 + tipoPronostico2;
			prono4[1] = participante;
			i++;
			pronosti.setConvinaRes(prono4[0]);
			pronosti.setParticipante(prono4[1]);
			System.out.println(pronosti.getParticipante() + " Clave=> " + pronosti.getCombinaRes());
			pronoList.add(pronosti);
		} else if (i == 4) {
			prono5[0] = tipoPronostico1 + tipoPronostico2;
			prono5[1] = participante;
			i++;
			pronosti.setConvinaRes(prono5[0]);
			pronosti.setParticipante(prono5[1]);
			System.out.println(pronosti.getParticipante() + " Clave=> " + pronosti.getCombinaRes());
			pronoList.add(pronosti);
		} else if (i == 5) {
			prono6[0] = tipoPronostico1 + tipoPronostico2;
			prono6[1] = participante;
			i++;
			pronosti.setConvinaRes(prono6[0]);
			pronosti.setParticipante(prono6[1]);
			System.out.println(pronosti.getParticipante() + " Clave=> " + pronosti.getCombinaRes());
			pronoList.add(pronosti);
		} else if (i == 6) {
			prono7[0] = tipoPronostico1 + tipoPronostico2;
			prono7[1] = participante;
			i++;
			pronosti.setConvinaRes(prono7[0]);
			pronosti.setParticipante(prono7[1]);
			System.out.println(pronosti.getParticipante() + " Clave=> " + pronosti.getCombinaRes());
			pronoList.add(pronosti);
		} else if (i == 7) {
			prono8[0] = tipoPronostico1 + tipoPronostico2;
			prono8[1] = participante;
			i++;
			pronosti.setConvinaRes(prono8[0]);
			pronosti.setParticipante(prono8[1]);
			System.out.println(pronosti.getParticipante() + " Clave=> " + pronosti.getCombinaRes());
			pronoList.add(pronosti);
			
			Puntos puntos = new Puntos(pronoList, null);
			puntos.setPronoList(pronoList);
			
		}

	}
	
	/*private static void calcularPuntos() {
		
		
		
		
		List<Pronostico> pronoList = puntoClass.getPronoList();
		List<Resultado> resultaList = puntoClass.getResultaList();
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
		                        	particiPunto1= pronoList.get(i).getParticipante();
		                        }
		                        if((pronoList.get(i).getNumeroPro())==re.getNumeroPartido()+4) { // Si el número de Pronóstico es = al número del partido + 4(porque son 4 resultados contra 8 pronosticos)
			                    	
			                        puntaje2 ++;
			                        particiPunto2= pronoList.get(i).getParticipante();
			                       }
		                    } 
		            }	      
		           
		      }	
					
			if((puntaje == 1 || puntaje == 0) & (particiPunto1 != null)) {// Verificamos si el resultado es plural o singular para mostrarlo
				System.out.println("Acierto de "+particiPunto1+": "+puntaje+ " punto");
			}else {
				System.out.println("Aciertos de "+particiPunto1+": "+puntaje+ " puntos ");
			}
			if((puntaje2 == 1 || puntaje2 == 0) & (particiPunto2  != null)) {// Verificamos si el resultado es plural o singular para mostrarlo
				System.out.println("Acierto de "+particiPunto2+": "+puntaje2+ " punto");
			}else {
				System.out.println("Aciertos de "+particiPunto2+": "+puntaje2+ " puntos ");
			}
			
		
		
	}*/
}
