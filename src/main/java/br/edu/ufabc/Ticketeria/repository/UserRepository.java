package br.edu.ufabc.Ticketeria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.edu.ufabc.Ticketeria.model.UserVO;

public interface UserRepository extends CrudRepository<UserVO, Long>{

	@Query("SELECT a FROM UserVO a WHERE a.username=:username")
    List<UserVO> findByUsername(@Param("username") String username);
	
	@Query("SELECT a FROM UserVO a WHERE a.username=:username AND a.password=:password")
    List<UserVO> findByUsernamePassword(@Param("username") String username, @Param("password") String password);
	
}
