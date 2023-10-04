package com.addiction.shoes.addictionshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.addiction.shoes.addictionshoes.model.Cliente;
import com.addiction.shoes.addictionshoes.repository.ClienteRepository;


@Controller
@RequestMapping("/addiction-shoes/cliente")
public class ClienteController {
	
	@Autowired //Injeção de dependência
	private ClienteRepository clienteRepository;
	
	
	
	//Carregar o formulario de cadastro
	@GetMapping("/novo-cliente")
	public String novoCliente(Cliente cliente, Model model) {
		
		model.addAttribute("cliente",cliente);
		
		return "addiction-shoes/cad";
		
	}
	
	
	
	@PostMapping("/add-cliente")
	public String addCliente(Cliente cliente, Model model){
		
		cliente.setCodStatus(true);
		
		Cliente clienteDB = clienteRepository.save(cliente);
		
		return "redirect:/addiction-shoes/cliente/home";
	}
	
	@GetMapping("/home")
	public String showPageHome() {
		
		return "/addiction-shoes/";
	}
}
