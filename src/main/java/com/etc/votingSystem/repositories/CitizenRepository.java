package com.etc.votingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etc.votingSystem.entity.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen,Integer>{
	
	public Citizen findByName(String name);
	
	
}
