package com.ejemplos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//marca la clase como un componente controlador de Spring
//con CTRL+SPACE importamos
//con CTRL+clic da informacion de la anotacion
@Controller
public class IndexController0 {
	
	@GetMapping({"/index","/","/home"})
	public String index() {
		return ("index");
	}
}
