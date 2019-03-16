package com.etc.votingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="citizens")
@Entity
public class Citizen {
	
	@Id
	@Column(name="UID")
	private Long id;
	
	@Column(name="citizen_name")
	private String name;
	
	@Column(name="has_voted")
	private Boolean hasVoted;
	

	public Boolean getHasVoted() {
		return hasVoted;
	}

	public void setHasVoted(Boolean hasVoted) {
		this.hasVoted = hasVoted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Citizen() {
		super();
	}

	public Citizen(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
