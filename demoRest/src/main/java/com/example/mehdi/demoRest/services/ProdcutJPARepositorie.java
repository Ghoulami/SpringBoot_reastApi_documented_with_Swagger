package com.example.mehdi.demoRest.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.mehdi.demoRest.entities.Product;

public interface ProdcutJPARepositorie extends JpaRepository<Product,Integer>{

}
