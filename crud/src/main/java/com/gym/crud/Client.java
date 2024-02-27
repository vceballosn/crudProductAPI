package com.gym.crud;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Table (name = "client")

public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
    private String name;
    private float price;
    private LocalDate dateCreation;
    @Transient
    private int card;
 
    
    public Client() {
    	
    }
public Client(Long id, String name ,float price, LocalDate dateCreation ) {
	this.id =id;
	this.name=name;
	this.price = price;
	this.dateCreation = dateCreation;

    	
    }

public Client(String name ,float price, LocalDate dateCreation) {
	this.name=name;
	this.price = price;
	this.dateCreation = dateCreation;

    	
    }
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public LocalDate getDateCreation() {
	return dateCreation;
}
public void setDateCreation(LocalDate dateCreation) {
	this.dateCreation = dateCreation;
}
public int getCard() {
	return Period.between(this.getDateCreation(),LocalDate.now()).getYears();
}
public void setCard(int card) {
	this.card = card;
}
}
