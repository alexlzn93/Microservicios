package com.alex.microserviciosDatosClientes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alex.microserviciosDatosClientes.util.Cliente;

@SpringBootApplication
public class MicroserviciosDatosClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosDatosClientesApplication.class, args);
	}

	//Creo un bean para que automaticamente cuando arranque el proyecto se ejecute
	@Bean
	public List<Cliente> lista_clientes(){
		List<Cliente> clientes= new ArrayList();
		Cliente c1= new Cliente(1, 1, "Alejandro", 5415);
		Cliente c2= new Cliente(2, 1, "Juan", 54554);
		Cliente c3= new Cliente(3, 1, "Eduardo", 25454);
		Cliente c4= new Cliente(4, 2, "Pakito", 54454);
		Cliente c5= new Cliente(5, 2, "Tamara", 541045);
		Cliente c6= new Cliente(6, 2, "Veronica", 54544);
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		clientes.add(c4);
		clientes.add(c5);
		clientes.add(c6);
		return clientes;
	}
}
