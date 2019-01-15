package clases;

import java.time.LocalDate;

public class Gasto {

	private String lugar;
	private LocalDate fecha;
	private float monto;
	
	public Gasto(String nombreDelLugar, LocalDate fecha, float monto) {
		this.lugar = nombreDelLugar;
		this.fecha = fecha;
		this.monto = monto;
	}
	
	public float monto() {
		return this.monto;
	}
	public LocalDate fecha() {
		return this.fecha;
	}
	public String lugar() {
		return this.lugar;
	}
}
