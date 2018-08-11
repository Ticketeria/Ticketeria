package br.edu.ufabc.Ticketeria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufabc.Ticketeria.model.SessionVO;
import br.edu.ufabc.Ticketeria.repository.SessionRepository;

@Service
public class SessionService {
	
	@Autowired
	private SessionRepository repository;
	
	public void save(SessionVO ss){
		repository.save(ss);
	}
	
	public List<SessionVO> getAll() {
		return (List<SessionVO>) repository.findAll();
	}
}
