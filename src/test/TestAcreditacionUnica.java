package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.AcreditacionUnica;

class TestAcreditacionUnica {

	private AcreditacionUnica acreditacion;
	@BeforeEach
	public void setUp() {
		acreditacion = new AcreditacionUnica(LocalDate.of(2019, 1, 2),(float) 10.0);
	}
	
	@Test
	void testMontoDeAcreditacion() {
		assertEquals(10.0, acreditacion.monto());
	}

}
