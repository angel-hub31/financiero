package com.krakedev.financieroJUnit.IA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class BancoTestJUnit {
	@Test
    void testCrearCuentaIncrementaCodigo() {
        Banco banco = new Banco();
        int codigoInicial = banco.getUltimoCodigo(); // Debería ser 0 según el .class
        
        Cliente cliente = new Cliente("17555", "Pedro", "Gómez");
        Cuenta nuevaCuenta = banco.crearCuenta(cliente);
        
        // Verifica que el ID se generó correctamente (asumiendo formato "c" + codigo)
        assertNotNull(nuevaCuenta);
        assertEquals(codigoInicial + 1, banco.getUltimoCodigo());
        assertEquals(cliente, nuevaCuenta.getPropietario());
    }

}
