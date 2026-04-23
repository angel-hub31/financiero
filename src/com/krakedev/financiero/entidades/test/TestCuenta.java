package com.krakedev.financiero.entidades.test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;

public class TestCuenta {

	public static void main(String[] args) {
		Cliente cliente1=new Cliente("1004034391","Juan","Barragan");
		Cuenta c=new Cuenta("001");
		c.setPropietario(cliente1);
		c.setSaldoActual(500);
		c.setTipo("Ahorro");
		c.imprimir();
		
		
	}

}
