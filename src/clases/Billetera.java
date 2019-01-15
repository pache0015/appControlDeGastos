package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Billetera {

	private float saldo;
	private float sueldoFijo;
	private List<Gasto> historialDeGastos;
	private List<AcreditacionUnica> historialDeAcreditaciones;
	
	public Billetera() {
		saldo =  (float) 0.0;
		sueldoFijo = (float) 0.0;
		historialDeGastos = new ArrayList<Gasto>();
		historialDeAcreditaciones = new ArrayList<AcreditacionUnica>();
	}
	
	public float saldo() {
		return this.saldo;
	}
	public void establecerSueldoFijo(float sueldo) {
		this.sueldoFijo = sueldo;		
	}
	public float sueldoFijo() {
		return this.sueldoFijo;
	}

	
	
	public void acreditarMontoUnico(AcreditacionUnica unaAcreditacion) {
		this.saldo += unaAcreditacion.monto();
		this.historialDeAcreditaciones.add(unaAcreditacion);
		
	}
	public List<AcreditacionUnica> historialDeAcreditaciones(){
		return this.historialDeAcreditaciones;
	}
	public List<AcreditacionUnica> buscarAcreditacionPorFecha(LocalDate unaFecha) {
		return historialDeAcreditaciones.stream().filter(acreditacion -> acreditacion.fecha().isEqual(unaFecha)).collect(Collectors.toList());
	}

	
	

	public void aplicarGasto(Gasto unGasto) {
		this.saldo -= unGasto.monto();
		this.historialDeGastos.add(unGasto);
	}

	public List<Gasto> historialDeGastos() {
		return this.historialDeGastos;
	}

	public List<Gasto> buscarGastoPorFecha(LocalDate unaFecha) {
		return historialDeGastos.stream().filter(gasto -> gasto.fecha().isEqual(unaFecha)).collect(Collectors.toList());
	}

	
}
