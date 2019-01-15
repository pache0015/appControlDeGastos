package test;

import clases.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBilletera {

	private Billetera unaBilletera;
	private Gasto unGasto;
	private AcreditacionUnica unaAcreditacion;
	
	@BeforeEach
		public void setUp(){
			unaBilletera = new Billetera();
			unGasto = new Gasto("mc", LocalDate.of(2019, 1 , 2), (float)10.0);
			unaAcreditacion = new AcreditacionUnica(LocalDate.of(2019, 1, 2), (float)10.0);
	}
	
	@Test
	void testSaldoEnCero() {
		assertEquals((float)0.0, unaBilletera.saldo());
	}
	
	@Test
	void testSeAcreditaUnMontoUnico() {
		unaBilletera.acreditarMontoUnico(unaAcreditacion);
		assertEquals((float)10.0, unaBilletera.saldo());
	}
	
	@Test
	void testSeEstablaceUnSueldofijo() {
		unaBilletera.establecerSueldoFijo((float) 100.0);
		assertEquals((float)100.0, unaBilletera.sueldoFijo());
	}

	@Test
	void testSeAplicaUnGastoYEsteSeRestaDelSaldo() {
		unaBilletera.acreditarMontoUnico(unaAcreditacion);
		unaBilletera.aplicarGasto(unGasto);
		assertEquals((float)0.0, unaBilletera.saldo());
	}
	@Test
	void testSeAplicaUnGastoYEsteSeSumaAlHistorialDeGastos() {
		unaBilletera.aplicarGasto(unGasto);
		assertEquals(false, unaBilletera.historialDeGastos().isEmpty());
	}
	@Test
	void testSeBuscaUnGastoPorLaFechaEnElHistorialDeGastos() {
		LocalDate unaFecha = LocalDate.of(2019,1,2);
		unaBilletera.aplicarGasto(unGasto);
		List<Gasto> listConUnGasto = new ArrayList<Gasto>();
		listConUnGasto.add(unGasto);
		
		assertEquals(listConUnGasto, unaBilletera.buscarGastoPorFecha(unaFecha));
	}
	@Test
	void testSeAcreditaUnMontoUnicoYSeGuardaEnUnHistorialDeACreditaciones() {
		LocalDate unaFecha = LocalDate.of(2019,1,2);
		unaBilletera.acreditarMontoUnico(unaAcreditacion);		
		List<AcreditacionUnica> listConUnaAcreditacion = new ArrayList<AcreditacionUnica>();
		listConUnaAcreditacion.add(unaAcreditacion);
		
		assertEquals(listConUnaAcreditacion, unaBilletera.buscarAcreditacionPorFecha(unaFecha));
	}
}
