package br.edu.ufabc.Ticketeria.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ufabc.Ticketeria.model.MovieVO;
import br.edu.ufabc.Ticketeria.model.SessionVO;
import br.edu.ufabc.Ticketeria.model.UserRole;
import br.edu.ufabc.Ticketeria.model.UserVO;
import br.edu.ufabc.Ticketeria.model.form.NewMovieForm;
import br.edu.ufabc.Ticketeria.model.form.NewSessionForm;
import br.edu.ufabc.Ticketeria.service.MovieService;
import br.edu.ufabc.Ticketeria.service.SessionService;

@Controller
public class AdminController {
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private SessionService sessionService;

	@RequestMapping("/adminCadastrarFilmeForm")
	public String newMovieForm(HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("usuarioLogado");
		if(user==null) {
			System.out.println("Usuario null...");
			user = new UserVO();
		}
		if(user.getRole()!=UserRole.ADMIN) {
			return "redirect:home";
		}
		model.addAttribute("user", user);

		model.addAttribute("newmovieform", new NewMovieForm());
		
		return "newMovieForm";
	}
	
	@RequestMapping("/adminCadastrarFilme")
	public String newMovie(@ModelAttribute("newmovieform") NewMovieForm newMovieForm, HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("usuarioLogado");
		if(user==null) {
			System.out.println("Usuario null...");
			user = new UserVO();
		}		
		if(user.getRole()!=UserRole.ADMIN) {
			return "redirect:home";
		}
		model.addAttribute("user", user);

		MovieVO movie = new MovieVO();
		movie.setTitle(newMovieForm.getTitle());
		System.out.println(newMovieForm.getTitle());
		movieService.save(movie);

		return "redirect:home";
	}
	
	@RequestMapping("/adminCadastrarSessaoForm")
	public String newSessionForm(HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("usuarioLogado");
		if(user==null) {
			System.out.println("Usuario null...");
			user = new UserVO();
		}
		if(user.getRole()!=UserRole.ADMIN) {
			return "redirect:home";
		}
		model.addAttribute("user", user);

		model.addAttribute("newsessionform", new NewSessionForm());
		
		return "newSessionForm";
	}
	
	@RequestMapping("/adminCadastrarSessao")
	public String newSession(@ModelAttribute("newsessionform") NewSessionForm newSessionForm, HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("usuarioLogado");
		if(user==null) {
			System.out.println("Usuario null...");
			user = new UserVO();
		}		
		if(user.getRole()!=UserRole.ADMIN) {
			return "redirect:home";
		}
		model.addAttribute("user", user);

		SessionVO ss = new SessionVO();
		ss.setDia(newSessionForm.getDate());
		ss.setHorario(newSessionForm.getHour());
//		ss.setMovie(newSessionForm.getMovie());
//		ss.setTheater(newSessionForm.getTheater());

		return "redirect:home";
	}
	
}
