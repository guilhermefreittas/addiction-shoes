package com.addiction.shoes.addictionshoes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	
	
	
	//visualizar clientes
	/*@GetMapping("/todos-clientes")
	public String listarCliente(Model model) {
		
		model.addAttribute("cliente", clienteRepository.findAll());
		return "cad";
	}
	*/
	
	//Carregar o formulario de cadastro
	@GetMapping("/novo-cliente")
	public String novoCliente(Cliente cliente, Model model) {
		model.addAttribute("cliente",cliente);
		return "cad";	
	}
	
	
	//Cadastrar (inserir)
	
	@PostMapping("/add-cliente")
	public String addCliente(Cliente cliente, BindingResult result, Model model){
		if(result.hasErrors()) {
			return "addiction-shoes/cad";
		}
		Cliente clienteDB = clienteRepository.save(cliente);
		cliente.setCodStatus(true);
		return "redirect:/addiction-shoes/cliente/todos-clientes";
	}
	
	@GetMapping("/todos-clientes")
	public List<Cliente> listarCliente(){
		return clienteRepository.findAll();
		
	}
	
}
