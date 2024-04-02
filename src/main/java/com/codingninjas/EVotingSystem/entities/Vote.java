package com.codingninjas.EVotingSystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Vote {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	 // (One To One relationship with User entity)
	 @OneToOne
	 @JoinColumn(name = "user_id")
	 private User user;
	 //(Many To One relationship with Election entity)
	 @ManyToOne
	 @JoinColumn(name="election_id")
	 private Election election;
	 // (Many To One relationship with ElectionChoice entity)
	 @ManyToOne
	 @JoinColumn(name = "election_choice_id")
	 private ElectionChoice electionChoice;
	 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Election getElection() {
		return election;
	}
	public void setElection(Election election) {
		this.election = election;
	}
	public ElectionChoice getElectionChoice() {
		return electionChoice;
	}
	public void setElectionChoice(ElectionChoice electionChoice) {
		this.electionChoice = electionChoice;
	}	 
}