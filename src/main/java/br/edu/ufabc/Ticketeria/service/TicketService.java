package br.edu.ufabc.Ticketeria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufabc.Ticketeria.model.TicketVO;
import br.edu.ufabc.Ticketeria.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository repository;
	
	public void salvar(TicketVO ticket) {
		repository.save(ticket);
	}
	
}
