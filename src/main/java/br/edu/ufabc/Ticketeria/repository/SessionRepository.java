package br.edu.ufabc.Ticketeria.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ufabc.Ticketeria.model.SessionVO;

public interface SessionRepository extends CrudRepository<SessionVO, Long> {
	
}
