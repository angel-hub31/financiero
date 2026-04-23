package com.krakedev.financiero.entidades.test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestFinanciero {

	public static void main(String[] args) {
		Banco miBanco = new Banco();
		Cliente cliente1 = new Cliente("1712345678", "Juan", "Perez");
		Cliente cliente2 = new Cliente("1787654321", "Maria", "Lopez");

		Cuenta c1 = miBanco.crearCuenta(cliente1);
		Cuenta c2 = miBanco.crearCuenta(cliente2);

		miBanco.depositar(500.0, c1);

		boolean exito = miBanco.transferir(c1, c2, 200.0);

		System.out.println("Transferencia exitosa: " + exito);
		c1.imprimir();
		c2.imprimir();
	}
}
