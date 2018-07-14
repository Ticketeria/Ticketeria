package br.edu.ufabc.Ticketeria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufabc.Ticketeria.model.MovieVO;
import br.edu.ufabc.Ticketeria.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	public void salvar(MovieVO movie) {
		repository.save(movie);
	}

	public List<MovieVO> getAll() {

		return (List<MovieVO>) repository.findAll();
	}

	public Optional<MovieVO> getById(Long id) {

		return repository.findById(id);
	}
}
