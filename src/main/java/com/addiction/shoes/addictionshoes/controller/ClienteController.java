package com.addiction.shoes.addictionshoes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.addiction.shoes.addictionshoes.model.Cliente;
@Controller
@RequestMapping("/addictionshoes/cliente")
public class ClienteController {
	
	List<Cliente> listaDeClientes = new ArrayList<Cliente>();
	
	@GetMapping("/listar")
	public String litarCliente(Model model) {
	
		model.addAttribute("listaDeClientes",listaDeClientes);
		return "clientes";
	}
	
	@GetMapping("/novo-cliente")
	public String novoCliente(Cliente cliente, Model model) {
		
		model.addAttribute("cliente",cliente);
		
		return "novo-cliente";
		
	}
	
	@PostMapping("/add-cliente")
	public String gravarNovoCliente(Cliente cliente) {
		
		listaDeClientes.add(cliente);
		
		return "redirect:/addictionshoes/cliente/listar";
		
	}
}
