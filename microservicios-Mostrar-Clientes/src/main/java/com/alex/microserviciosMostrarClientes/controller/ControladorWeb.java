package com.alex.microserviciosMostrarClientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alex.microserviciosMostrarClientes.service.ClienteSERVICE;
import com.alex.microserviciosMostrarClientes.util.Cliente;
import com.alex.microserviciosMostrarClientes.util.Datos_Cliente;

@Controller
public class ControladorWeb {

	@Autowired
	ClienteSERVICE clienteservice;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/clientes")
	public String lista_clientes(Model model) {
		Datos_Cliente dt= clienteservice.get_datos_cliente();
		System.out.println(dt.getClientes());
		model.addAttribute("clientes", dt.getClientes());
		
		return "muestra_clientes";
	}
	@RequestMapping("/clientes/tipo/{tipo}")
	public String lista_clientes_porTipo(Model model,@PathVariable("tipo") int tipo) {
		Datos_Cliente datosClienteporTipo= clienteservice.get_datos_cliente_porTipo(tipo);
		System.out.println(datosClienteporTipo.getClientes());
		model.addAttribute("clientes", datosClienteporTipo.getClientes());
		
		return "muestra_clientes";
	}
	@RequestMapping("/clientes/cuenta/{numCuenta}")
	public String cliente_numCuenta(Model model,@PathVariable("numCuenta") int numCuenta,@RequestParam("numeroCuenta") int nCuenta) {
		Cliente cliente_cuenta= clienteservice.cliente_numeroCuenta(numCuenta);
		System.out.println(cliente_cuenta);
		System.out.println(nCuenta+"numerocuenta");
		model.addAttribute("numeroCuenta", nCuenta);
		model.addAttribute("numeroCuenta", numCuenta);
		model.addAttribute("clientes", cliente_cuenta);
		
		return "muestra_clientes";
	}

	@PostMapping("/clientes/cuenta")
	public String formulario_numCuenta(Model model,@RequestParam ("numcta")int numcta) {
		
		Cliente cliente_cuenta= clienteservice.cliente_numeroCuenta(numcta);
		System.out.println(cliente_cuenta);
		System.out.println("--------------------------------------");
		System.out.println(numcta+"numerocuenta");
		//model.addAttribute("numeroCuenta", nCuenta);
		
		model.addAttribute("clientes", cliente_cuenta);
		
		return "muestra_clientes";
	}
	//<td><a th:href="@{'/cliente/delete/' + ${cliente.id}}">Eliminar</a></td>
	@RequestMapping("/cliente/delete/{id}")
	public String eliminar_cliente(Model model,@PathVariable("id") int id) {
		clienteservice.eliminar_cliente(id); //borro el cliente
		//cuando elimine me retorna el metodo lista_clientes que refresca la lista de clientes
		return this.lista_clientes(model);
		
		/*Datos_Cliente listaClientes= clienteservice.get_datos_cliente();
		System.out.println(listaClientes);
		model.addAttribute("clientes", listaClientes);
		
		return "muestra_clientes";*/
	}
}
