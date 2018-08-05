package br.edu.ufabc.Ticketeria.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ufabc.Ticketeria.model.MovieVO;
import br.edu.ufabc.Ticketeria.model.TheaterVO;
import br.edu.ufabc.Ticketeria.model.UserRole;
import br.edu.ufabc.Ticketeria.model.UserVO;
import br.edu.ufabc.Ticketeria.model.form.NewMovieForm;
import br.edu.ufabc.Ticketeria.model.form.NewTheaterForm;
import br.edu.ufabc.Ticketeria.service.MovieService;
import br.edu.ufabc.Ticketeria.service.TheaterService;

@Controller
public class AdminController {
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private TheaterService theaterService;

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
	
	@RequestMapping("/adminCadastrarCinemaForm")
	public String newTheaterForm(HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("usuarioLogado");
		if (user == null) {
			System.out.println("Usuario null...");
			user = new UserVO();
		}
		if(user.getRole()!=UserRole.ADMIN) {
			return "redirect:home";
		}
		
		model.addAttribute("user", user);

		model.addAttribute("newtheaterform", new NewTheaterForm());
		
		return "newTheaterForm";
	}
	
	@RequestMapping("/adminCadastrarCinema")
	public String newTheater(@ModelAttribute("newtheaterform") NewTheaterForm newTheaterForm, HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("usuarioLogado");
		if(user==null) {
			System.out.println("Usuario null...");
			user = new UserVO();
		}		
		if(user.getRole()!=UserRole.ADMIN) {
			return "redirect:home";
		}
		model.addAttribute("user", user);

		TheaterVO theater = new TheaterVO();
		theater.setNome(newTheaterForm.getNome());
		theater.setCidade(newTheaterForm.getCidade());
		theater.setSalas(newTheaterForm.getSala());
		System.out.println(newTheaterForm.getNome());
		theaterService.save(theater);

		return "redirect:home";
	}
	
}
