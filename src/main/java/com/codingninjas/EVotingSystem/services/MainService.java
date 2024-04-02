package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;
import com.codingninjas.EVotingSystem.repositories.UserRepository;
import com.codingninjas.EVotingSystem.repositories.VoteRepository;

@Service
public class MainService {
	
	@Autowired
	private ElectionRepository electionRepository;
	
	@Autowired
	private ElectionChoiceRepository electionChoiceRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VoteRepository voteRepository;
	// 1. Election Service:
	
	public Election addElection(Election election) {
		return electionRepository.save(election);
	}
	
	public List<Election> getAllElections() {
		// TODO Auto-generated method stub
		return electionRepository.findAll();
	}

	// 2. ElectionChoice Service
	public ElectionChoice addElectionChoice(ElectionChoice electionChoice) {
		// TODO Auto-generated method stub
		long electionId = electionChoice.getElection().getId();
		Election election = electionRepository.findById(electionId).get();
		electionChoice.setElection(election);
		return electionChoiceRepository.save(electionChoice);
	}
	
	public List<ElectionChoice> getAllElectionChoice() {
		// TODO Auto-generated method stub
		return electionChoiceRepository.findAll();
	}
	
	public List<ElectionChoice> getAllElectionChoiceByElection(Election election) {
		// TODO Auto-generated method stub
		Election existedElection = electionRepository.findById(election.getId()).get();
		return electionChoiceRepository.findAllByElection(existedElection);
	}
	
	// 3. User Service
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	// 4. Vote Service
	public void addVote(Vote vote) {
		// TODO Auto-generated method stub
		userRepository.findById(vote.getId());
		electionChoiceRepository.findById(vote.getElectionChoice().getId());
		electionRepository.findById(vote.getElection().getId());
		voteRepository.save(vote);
	}
	
	public List<Vote> getVotes() {
		// TODO Auto-generated method stub
		return voteRepository.findAll();
	}
	
	public int getVoteCount() {
		// TODO Auto-generated method stub
		return voteRepository.getVotesCount();
	}
	public long getVoteCountByElection(Election election) {
		// TODO Auto-generated method stub
		return voteRepository.countByElection(election);
	}
	
	// 5. Results Service
	public ElectionChoice getElectionWinner(Election election) {
		// TODO Auto-generated method stub
		return voteRepository.getElectionWinner(election);
	}
	
}