package com.codingninjas.EVotingSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.services.MainService;

@RestController
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	// 1. Election Endpoints:
	
	//POST "/add/election" (@RequestBody Election election): It creates a new election.
	@PostMapping("/add/election")
	public Election addElection(@RequestBody Election election) {
		return mainService.addElection(election);
	}
	// GET "/get/elections": It retrieves the list of all elections.

	@GetMapping("/get/elections")
	public List<Election> getAllElections(){
		return mainService.getAllElections();
	}
	// 2. ElectionChoice Endpoints:
	
	// POST "/add/electionChoice" (@RequestBody ElectionChoice electionChoice): It adds a election choice.
	@PostMapping("/add/electionChoice")
	public ElectionChoice addElectionChoice(@RequestBody ElectionChoice electionChoice) {
		return mainService.addElectionChoice(electionChoice);
	}
	// GET "/get/electionChoices":
	@GetMapping("/get/electionChoices")
	public List<ElectionChoice> getAllElectionChoice(){
		return mainService.getAllElectionChoice();
	}
	
	// POST "/count/election/choices" (@RequestBody Election election): It retrieves the list of all choices for the given election.
	@PostMapping("/count/election/choices")
	public long getAllElectionChoiceByElection(@RequestBody Election election){
		return mainService.getAllElectionChoiceByElection(election).size();
	}
	
	// 3. User Endpoints:
	// POST "/add/user" (@RequestBody User user): It creates a new user into the database.
	@PostMapping("/add/user")
	public void addUser(@RequestBody User user) {
		mainService.addUser(user);
	}
	
	
	// GET "/get/users": It fetches the list of all users from the database.
	@GetMapping("/get/users")
	public List<User> getUser() {
		return mainService.getUsers();
	}

	// 4. Vote Endpoints:
	// GET "/get/votes": It fetches the list of all votes from the database.
	@PostMapping("/add/vote")
	public void  addVote(@RequestBody Vote vote) {
		mainService.addVote(vote);
	}
	
	@GetMapping("/get/votes")
	public List<Vote> getVotes() {
		return mainService.getVotes();
	}
	
	// GET "/count/votes": It fetches the count of total votes from the database.
	@GetMapping("/count/votes")
	public int getVoteCount() {
		return mainService.getVoteCount();
	}
	
	// POST "/count/election/votes" (@RequestBody Election election): It returns the count of total votes by-election in long.
	@PostMapping("/count/election/votes")
	public long getVoteCountByElection(@RequestBody Election election) {
		return mainService.getVoteCountByElection(election);
	}
	
	// 5. Results Endpoints
	// POST "/winner/election" (@RequestBody Election election): It retrieves the ElectionChoice for a specific election as the winner
	@PostMapping("/winner/election")
	public ElectionChoice getElectionWinner(@RequestBody Election election) {
		return mainService.getElectionWinner(election);
	}
}
