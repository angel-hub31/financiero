package com.krakedev.financiero.entidades;

public class Cuenta {
	private String id;
	private double saldoActual;
	private String tipo;
	private Cliente propietario;

	public Cuenta(String id) {

		this.id = id;
		this.saldoActual = 0;
		this.tipo = "A";
		//solucion a nullPointerExceptio
		this.propietario= new Cliente();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getPropietario() {
		return propietario;
	}

	public void setPropietario(Cliente propietario) {
		this.propietario = propietario;
	}

	public void imprimir() {
		System.out.println("Cuenta: " + id + " | SaldoActual: " + saldoActual + " | Tipo: " + tipo);
		if(propietario !=null) {
			System.out.println("Cedula cliente: "+propietario.getCedula());

		}
	}

}
