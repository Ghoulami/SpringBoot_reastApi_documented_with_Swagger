package com.exemple.mehdi.demoRest.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Commande {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "date")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date date;
		
	@ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JsonBackReference
	@JsonManagedReference 
	@JoinTable(name = "product_commande", 
		joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
	private List<Product> products = new ArrayList<Product>();
	
	public Commande() {}
	
	public Commande(int id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
