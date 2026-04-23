package com.krakedev.financieroJUnit.IA;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;

public class TestClienteIA {
	@Test
    void testCrearCliente() {
        Cliente cliente = new Cliente("1712345678", "Juan", "Pérez");
        
        assertEquals("1712345678", cliente.getCedula());
        assertEquals("Juan", cliente.getNombre());
        assertEquals("Pérez", cliente.getApellido());
    }

    @Test
    void testSetters() {
        Cliente cliente = new Cliente();
        cliente.setCedula("0987654321");
        assertEquals("0987654321", cliente.getCedula());
    }

}
