package com.alex.microserviciosDatosClientes.util;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

public class Datos_Cliente implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private List<Cliente> clientes;

	public Datos_Cliente(List<Cliente> clientes) {
		super();
		this.clientes = clientes;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
