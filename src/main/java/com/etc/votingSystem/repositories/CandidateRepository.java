package com.etc.votingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etc.votingSystem.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Integer>{
	
	public Candidate findById(Long id);
	
}
