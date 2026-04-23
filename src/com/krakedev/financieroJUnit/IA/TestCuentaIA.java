package com.krakedev.financieroJUnit.IA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;

public class TestCuentaIA {
	@Test
    void testInicializacionCuenta() {
        Cuenta cuenta = new Cuenta("AH-100");
        
        assertEquals("AH-100", cuenta.getId());
        assertNotNull(cuenta.getPropietario(), "El propietario no debería ser nulo tras el constructor");
        assertEquals(0.0, cuenta.getSaldoActual());
    }

    @Test
    void testAsignarPropietario() {
        Cuenta cuenta = new Cuenta("CH-200");
        Cliente cliente = new Cliente("171111", "Ana", "Díaz");
        
        cuenta.setPropietario(cliente);
        assertEquals("171111", cuenta.getPropietario().getCedula());
    }
}
