package com.ejemplos.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ejemplos.models.Usuario;



@Controller
//@RequestMapping("/app")
public class IndexController1 {
	
	@GetMapping("/")
	public String index(Model model) {
		Date fecha = new Date();
		model.addAttribute("fecha", fecha.toString());
		return "index";
	}
	
	//pasar datos del controlador a la vista con la interfaz Model
	@GetMapping("/index2")
	public String index2(Model model) {
		model.addAttribute("titulo", "hola Spring: pasar datos del controlador a la vista "
				+ "con la interfaz Model");
		
		return "index2";
	}
	
	//pasar datos del controlador a la vista con la clase ModelMap
	@GetMapping("/index3")
	public String index3(ModelMap model) {
		model.addAttribute("titulo", "Pablo, estate puto quieto");
		return "index2";
	}
	
	//pasar datos del controlador a la vista con interfaz Map
	@GetMapping("/index4")
	public String index4(Map<String, Object> map) {
		map.put("titulo", "hola Spring: pasar datos del controlador "
				+ "a la vista con la interfaz Map");
		return "index2";
	}
	
	//pasar dats del controlador a la vista con ModelAndView
	@GetMapping("/index5")
	public ModelAndView index5(ModelAndView mv) {
		mv.addObject("titulo", "hola Spring: pasar datos del controlador "
				+ "a la vista con ModelAndView");
		mv.setViewName("index2");
		return mv;
	}
	
	//haciendo uso de objeto modelo podíamos haber usado tb getmapping
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Luis");
		usuario.setApellido("Vázquez Carmona");
		//usuario.setEmail("luis.vazquez.carmona.alu@iesjulioverne.es");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil ".concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	//probamos directiva if para que indique que la lista de usuario esta vacia
	@GetMapping("/listar1")
	public String listar1(Model model) {
		List<Usuario> usuarios =new ArrayList<Usuario>();
		model.addAttribute("titulo","Listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}
	
	@RequestMapping("/listar2")
	public String listar2(Model model) {
		//List<Usuario> usuarios =new ArrayList<Usuario>();
		//usuarios.add(new Usuario("Luis", "Vázquez", "luis@luis.luis"));
		//usuarios.add(new Usuario("Pablo", "Rojo", "pablo@pablo.pablo"));
		
		model.addAttribute("titulo","Listado de usuarios");
		//model.addAttribute("usuarios", poblarUsuarios());
		return "listar";
	}
	
	//pasar datos a la vista usando @ModelAttribute.
	//Este atributo puede ser usado por todos los metodos del controlador
	//y en las vistas que el controlador llame
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Luis", "Vázquez", "luis@luis.luis"),
				new Usuario("Pablo", "Rojo", "pablo@pablo.pablo"));
		return usuarios;
	}
	
}














