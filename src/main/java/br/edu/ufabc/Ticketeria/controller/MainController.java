package br.edu.ufabc.Ticketeria.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ufabc.Ticketeria.model.MovieVO;
import br.edu.ufabc.Ticketeria.model.TicketVO;
import br.edu.ufabc.Ticketeria.model.UserVO;
import br.edu.ufabc.Ticketeria.model.form.BuyTicketForm;
import br.edu.ufabc.Ticketeria.repository.TicketRepository;
import br.edu.ufabc.Ticketeria.service.MovieService;
import br.edu.ufabc.Ticketeria.service.TicketService;

@Controller
public class MainController {

	@Autowired
	private MovieService movieService;
	@Autowired
	private TicketService ticketService;
//	private UserRepository UserServiceRepository;
	
	@RequestMapping("/home")
    public String home(HttpSession session, Model model) {

		UserVO user = (UserVO) session.getAttribute("usuarioLogado");
		if(user==null) {
			System.out.println("Usuario null...");
			user = new UserVO();
		}
		
		model.addAttribute("user", user);
		System.out.println(user.getUsername());

        return "home";
    }
	
	@RequestMapping("/")
    public String index() {
        return "redirect:home";
    }
	
	@RequestMapping("/ingresso")
    public String ingresso() {
        return "ticket";
    }
	
	@RequestMapping("/paginaDeErro")
    public String error() {
        return "error";
    }
	
	
	
	
}
