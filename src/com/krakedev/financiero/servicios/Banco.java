package com.krakedev.financiero.servicios;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;

public class Banco {
	private int ultimoCodigo=1000;

	public Banco() {
		
	}
	
	public Cuenta crearCuenta(Cliente cliente) {
		String codigoStr=ultimoCodigo + "";
		ultimoCodigo++;
		
		Cuenta nuevaCuenta=new Cuenta(codigoStr);
		nuevaCuenta.setPropietario(cliente);
		return nuevaCuenta;
		
	}
	public boolean depositar(double monto,Cuenta cuenta) {
		if(monto>0) {
			double nuevoSaldo=cuenta.getSaldoActual()+monto;
			cuenta.setSaldoActual(nuevoSaldo);
			return true;
			
		}
		return false;
	}
	
	public  boolean retirar(double monto,Cuenta cuenta) {
		if(monto>0 && monto <=cuenta.getSaldoActual() ) {
			cuenta.setSaldoActual(cuenta.getSaldoActual()-monto);
			return true;
			
		}
		return false;	
	}
	public boolean transferir(Cuenta origen,Cuenta destino,double monto) {
		if(retirar(monto,origen)) {
			return depositar(monto,destino);
		}
		return false;
	}
	public int getUltimoCodigo() {
		return ultimoCodigo;
	}

	public void setUltimoCodigo(int ultimoCodigo) {
		this.ultimoCodigo = ultimoCodigo;
	}
	
	
}
