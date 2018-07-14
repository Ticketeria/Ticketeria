package br.edu.ufabc.Ticketeria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufabc.Ticketeria.model.TicketVO;

@Repository
public interface TicketRepository extends CrudRepository<TicketVO, Long>{

}
