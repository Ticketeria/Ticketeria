package br.edu.ufabc.Ticketeria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufabc.Ticketeria.model.UserVO;
import br.edu.ufabc.Ticketeria.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public Iterable<UserVO> obterTodos() {

		Iterable<UserVO> users = repository.findAll();

		return users;

	}

	public UserVO findByUsername(String username) {

		List<UserVO> users = new ArrayList<UserVO>();
		
		users = repository.findByUsername(username);

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}
	
	public UserVO findByUsernamePassword(String username, String password) {

		List<UserVO> users = new ArrayList<UserVO>();
		
		users = repository.findByUsernamePassword(username, password);

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	public void salvar(UserVO user) {
		repository.save(user);
	}

}
