package com.example.mehdi.demoRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.mehdi.demoRest.services.CommandeJPARepositorie;
import com.exemple.mehdi.demoRest.entities.Commande;

@RestController
public class CommandeController {
	
	@Autowired
	private CommandeJPARepositorie commandeService;
	
	@GetMapping("/commandes")
	public List<Commande> getCommandes() {
		return commandeService.findAll();
	}
	
	@GetMapping("/commandes/{id}")
	public Commande getCommandeById(@PathVariable int id) {
		return commandeService.findById(id).get();
	}
	
	@DeleteMapping("/commandes/{id}")
	public String DeleteCommandeById(@PathVariable int id) {
		commandeService.deleteById(id);
		return "Deleted";
	}
	
	@PostMapping("/commandes")
	public String addCommande(@RequestBody Commande commande) {
		commandeService.save(commande);
		return "Added";
	}
}
