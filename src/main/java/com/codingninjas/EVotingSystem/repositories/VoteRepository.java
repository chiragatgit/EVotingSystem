package com.codingninjas.EVotingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
	
	@Query(value = "select count(v) from Vote v")
	public int getVotesCount();
	
	public long countByElection(Election election);
	
	@Query(value = "select vec from Vote v join v.electionChoice vec where v.election = ?1 group by v.electionChoice   order by count(v.user) desc limit 1")
	public ElectionChoice getElectionWinner(Election election);
}