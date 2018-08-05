package br.edu.ufabc.Ticketeria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufabc.Ticketeria.model.TheaterVO;
import br.edu.ufabc.Ticketeria.repository.TheaterRepository;

@Service
public class TheaterService {
	@Autowired
	private TheaterRepository repository;
	
	public void save(TheaterVO theater) {
		repository.save(theater);
	}
	
	public List<TheaterVO> getAll(){
		return (List<TheaterVO>)repository.findAll();
	}
}
