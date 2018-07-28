package br.edu.ufabc.Ticketeria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.edu.ufabc.Ticketeria.model.UserRole;
import br.edu.ufabc.Ticketeria.model.UserVO;
import br.edu.ufabc.Ticketeria.service.UserService;



@Component
public class StartupCode {

	@Autowired
	private UserService userService;
	
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {

		

//		UserDao userDao = new UserDaoImpl();
//		User user = new User();
//		user.setId(1L);
//		user.setUsername("admin");
//		user.setPassword("admin");
//		userDao.save(user);
//		
//		System.out.println("OKKKKK");
//		
//		UserVO user = new UserVO();
//		user.setUsername("Zeh2");
//		user.setPassword("123");
//		user.setRole(UserRole.ADMIN);
//		
//		userService.salvar(user);
	
	}
}
