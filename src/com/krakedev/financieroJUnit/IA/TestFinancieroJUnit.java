package com.krakedev.financieroJUnit.IA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestFinancieroJUnit {
	@Test
    void testCrearCuentaConsecutiva() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1722334455", "Pedro", "Páramo");

        Cuenta cuenta1 = banco.crearCuenta(cliente);
        Cuenta cuenta2 = banco.crearCuenta(cliente);

        assertEquals("1000", cuenta1.getId());
        assertEquals("1001", cuenta2.getId());
    }
	@Test
    void testDepositarMontoValido() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1712345678", "Juan", "Perez");
        Cuenta cuenta = banco.crearCuenta(cliente);
        
        boolean resultado = banco.depositar(100.0, cuenta);

        assertTrue(resultado);
        assertEquals(100.0, cuenta.getSaldoActual());
    }
	@Test
    void testDepositarMontoInvalido() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1712345678", "Juan", "Perez");
        Cuenta cuenta = banco.crearCuenta(cliente);
        
        boolean resultado = banco.depositar(-50.0, cuenta);

        assertFalse(resultado);
        assertEquals(0.0, cuenta.getSaldoActual());
    }
	@Test
    void testRetirarExitoso() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1712345678", "Juan", "Perez");
        Cuenta cuenta = banco.crearCuenta(cliente);
        
        banco.depositar(500.0, cuenta);
        boolean resultado = banco.retirar(200.0, cuenta);

        assertTrue(resultado);
        assertEquals(300.0, cuenta.getSaldoActual());
    }
	@Test
    void testRetirarSaldoInsuficiente() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1712345678", "Juan", "Perez");
        Cuenta cuenta = banco.crearCuenta(cliente);
        
        banco.depositar(100.0, cuenta);
        boolean resultado = banco.retirar(150.0, cuenta);

        assertFalse(resultado);
        assertEquals(100.0, cuenta.getSaldoActual());
    }
	@Test
    void testTransferirExitoso() {
        Banco banco = new Banco();
        Cliente c1 = new Cliente("171", "Juan", "Perez");
        Cliente c2 = new Cliente("172", "Ana", "Gomez");
        
        Cuenta origen = banco.crearCuenta(c1);
        Cuenta destino = banco.crearCuenta(c2);
        
        banco.depositar(1000.0, origen);
        boolean resultado = banco.transferir(origen, destino, 400.0);

        assertTrue(resultado);
        assertEquals(600.0, origen.getSaldoActual());
        assertEquals(400.0, destino.getSaldoActual());
    }
}
