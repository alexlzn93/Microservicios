package com.alex.microserviciosMostrarClientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alex.microserviciosMostrarClientes.util.Cliente;
import com.alex.microserviciosMostrarClientes.util.Datos_Cliente;



@Service
public class ClienteSERVICE {

	
	@Autowired
	public RestTemplate restTemplate; //hace la llamada al microservicio
	
	public String serviceUrl;

	public ClienteSERVICE(String serviceUrl) {
		super();
		System.out.println(serviceUrl);
		this.serviceUrl = serviceUrl.startsWith("http")?serviceUrl:"http//"+serviceUrl; 
		System.out.println(serviceUrl);
	}
	
	//este metodo llama al microservicio1
	public Datos_Cliente get_datos_cliente() {
		Datos_Cliente datos_clientes= restTemplate.getForObject(serviceUrl, Datos_Cliente.class);
		return datos_clientes;
	}
	//este metodo es el que tengo que tocar
	public Datos_Cliente get_datos_cliente_porTipo(int tipo) {
		Datos_Cliente datos_clientes= restTemplate.getForObject(serviceUrl+"/tipo/{tipo}", Datos_Cliente.class,tipo);
		return datos_clientes;
	}
	public Cliente cliente_numeroCuenta(int numCuenta) {
		Cliente clienteCuenta= restTemplate.getForObject(serviceUrl+"/numeroCuenta/{numCuenta}",Cliente.class,numCuenta);
		return clienteCuenta;
	}
	public void eliminar_cliente(int id) {
		restTemplate.getForObject(serviceUrl+"/cliente/delete/{id}",Cliente.class,id);
		
	}
}
