package clases;

import java.time.LocalDate;

public class AcreditacionUnica {
	
	private LocalDate fecha;
	private float monto;
	
	public AcreditacionUnica(LocalDate unaFecha, float monto) {
		this.fecha = unaFecha;
		this.monto = monto;
	}

	public float monto() {
		return this.monto;
	}
	public LocalDate fecha() {
		return this.fecha;
	}
}
