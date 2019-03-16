package com.etc.votingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="candidates")
@Entity
public class Candidate {
	
	@Id
	@Column(name="ID")
	private Long id;
	
	public Candidate() {
		super();
	}

	@Column(name="candidate_name")
	private String name;

	@Column(name="Total_Votes")
	private int numberOfVotes;
	
	
	public int getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(int numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}

	public Long getId() {
		return id;
	}

	public Candidate(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	

}
