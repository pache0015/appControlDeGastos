package test;

import clases.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestGasto {

	private Gasto unGasto;
	@BeforeEach
	public void setUp() {
		unGasto = new Gasto("mc", LocalDate.of(2019, 1 , 2), (float)10.0);
	}
	
	@Test
	void testMontoDeGasto() {
		assertEquals( (float) 10.0, unGasto.monto());
	}

}
