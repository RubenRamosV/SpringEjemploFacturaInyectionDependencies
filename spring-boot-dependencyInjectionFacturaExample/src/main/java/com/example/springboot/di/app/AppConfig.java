package com.example.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.springboot.di.app.models.domain.ItemFactura;
import com.example.springboot.di.app.models.domain.Producto;

@Configuration
public class AppConfig {

	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems() {
		Producto p1 = new Producto("Producto 1", 10);
		Producto p2 = new Producto("Producto 2", 20);

		ItemFactura linea1 = new ItemFactura(p1, 1);
		ItemFactura linea2 = new ItemFactura(p2, 5);

		return Arrays.asList(linea1, linea2);
	}
	
	@Primary
	@Bean("itemsFacturaOficina")
	public List<ItemFactura> registrarItemsOficina() {
		Producto p1 = new Producto("Producto 1 Oficina", 300);
		Producto p2 = new Producto("Producto 2 Oficina", 55570);
		Producto p3 = new Producto("Producto 3 Oficina", 56570);
		Producto p4 = new Producto("Producto 4 Oficina", 90570);

		ItemFactura linea1 = new ItemFactura(p1, 1);
		ItemFactura linea2 = new ItemFactura(p2, 5);
		ItemFactura linea3 = new ItemFactura(p3, 8);
		ItemFactura linea4 = new ItemFactura(p4, 10);

		return Arrays.asList(linea1, linea2, linea3, linea4);
	}

	
	
	
	
	
	
	
	
}
