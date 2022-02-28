package Entidades;

import java.time.*;
import java.util.LinkedList;

public class Partido {

			private LocalDate fecha;
			private LocalTime hora;
			private String resultado;
			private LinkedList<String> incidencias;
			private int idEquipo1;
			private int idEquipo2;
			private String dniArbitro;
			private int numCancha;
			public LocalDate getFecha() {
				return fecha;
				
			}
			public void setFecha(LocalDate fecha) {
				this.fecha = fecha;
			}
			public LocalTime getHora() {
				return hora;
			}
			public void setHora(LocalTime hora) {
				this.hora = hora;
			}
			public String getResultado() {
				return resultado;
			}
			public void setResultado(String resultado) {
				this.resultado = resultado;
			}
			public LinkedList<String> getIncidencias() {
				return incidencias;
			}
			public void setIncidencias(LinkedList<String> incidencias) {
				this.incidencias = incidencias;
			}
			@Override
			public String toString() {
				return "Partido [fecha=" + fecha + ", hora=" + hora + ", resultado=" + resultado + ", incidencias="
						+ incidencias + "]";
			}
			public int getIdEquipo2() {
				return idEquipo2;
			}
			public void setIdEquipo2(int idEquipo2) {
				this.idEquipo2 = idEquipo2;
			}
			public int getIdEquipo1() {
				return idEquipo1;
			}
			public void setIdEquipo1(int idEquipo1) {
				this.idEquipo1 = idEquipo1;
			}
			public String getDniArbitro() {
				return dniArbitro;
			}
			public void setDniArbitro(String dniArbitro) {
				this.dniArbitro = dniArbitro;
			}
			public int getNumCancha() {
				return numCancha;
			}
			public void setNumCancha(int numCancha) {
				this.numCancha = numCancha;
			}
			
}
