package com.example.mehdi.demoRest.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.mehdi.demoRest.entities.Commande;

public interface CommandeJPARepositorie extends JpaRepository<Commande,Integer>{

}
