package br.edu.ufabc.Ticketeria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.edu.ufabc.Ticketeria.model.MovieVO;

public interface MovieRepository extends CrudRepository<MovieVO, Long> {

	@Query("SELECT a FROM MovieVO a")
	public List<MovieVO> getAll();
	
	@Query("SELECT a FROM MovieVO a WHERE a.id=:id")
	public MovieVO getById(@Param("id") Long id);
	
}
