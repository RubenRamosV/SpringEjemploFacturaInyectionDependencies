package com.example.springboot.di.app.models.domain;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Factura {

	@Autowired
	private Cliente cliente;
	
	@Value("${factura.descripcion}")
	private String descripcion;
	
	/*Aqui existen dos listas que tienen implementada la misma interfaz, por lo que tenemos que 
	 * decirle a Spring con cual va a inyectar la dependencia, por lo que se agrega primary 
	 * a una de las dos listas*/
	@Autowired
	private List<ItemFactura> items;

	/*Este metodo se va a ejecutar despues de crearce el objeto con la anotacion postConstruct
	 * se puede ejecutar cualquier accion deseada*/
	@PostConstruct
	private void init() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Este texto se esta agregando"
				+ "despues de la construccion del objeto con @PostConstruct"));
	}
	
	/*Este metodo se va a ejectuar antes de que se destruya el objeto*/
	@PreDestroy
	private void destroy() {
		System.out.println("Aqui se destruye el objeto de factura");
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}
