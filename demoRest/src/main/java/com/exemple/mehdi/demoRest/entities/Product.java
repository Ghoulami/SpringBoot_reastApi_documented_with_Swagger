package com.exemple.mehdi.demoRest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private double price;
	
	@ManyToMany
	@JoinTable(name = "product_commande", 
			joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"))
	private List<Commande> commandes  = new ArrayList<Commande>();
	
	public Product() {}
	
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
