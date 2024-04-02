package com.codingninjas.EVotingSystem.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ElectionChoice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private String name;
	//(Many To One relationship with Election entity)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "election_id")
    private Election election;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Election getElection() {
		return election;
	}
	public void setElection(Election election) {
		this.election = election;
	}  
    
}