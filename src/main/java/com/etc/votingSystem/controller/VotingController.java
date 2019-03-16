package com.etc.votingSystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.etc.votingSystem.entity.Candidate;
import com.etc.votingSystem.entity.Citizen;
import com.etc.votingSystem.repositories.CandidateRepository;
import com.etc.votingSystem.repositories.CitizenRepository;

@Controller
public class VotingController {

	public final Logger logger = Logger.getLogger(VotingController.class);  //Optional for console loging
	//imported jboss logger
	
	@Autowired
	CitizenRepository citizenRepo;
	@Autowired
	CandidateRepository candidateRepo;
	
	@RequestMapping("/")
	public String goToVote() {
		logger.info("returning vote.html file");  //optional
		return "vote.html";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam String name, Model model, HttpSession session) {
		
		Citizen citizen = citizenRepo.findByName(name);
		session.setAttribute("citizen",citizen);
		
		if(!citizen.getHasVoted()) {
			
			List<Candidate> candidates = candidateRepo.findAll();
			model.addAttribute("candidates",candidates);
			
			return "/performVoting.html";
		}
		else {
			return "/alreadyVoted.html";
		}
	}
	
	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam Long id, HttpSession session) {
		Citizen citizen = (Citizen) session.getAttribute("citizen");
		
		if(!citizen.getHasVoted()) {
			citizen.setHasVoted(true);
		
		Candidate c = candidateRepo.findById(id);
		c.setNumberOfVotes(c.getNumberOfVotes()+1);
		candidateRepo.save(c);
		citizenRepo.save(citizen);
		return "voted.html";
		}
		else {
			return "/alreadyVoted.html";
		}
		
	}
	
}
