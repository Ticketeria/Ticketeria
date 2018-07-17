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
import br.edu.ufabc.Ticketeria.service.MovieService;
import br.edu.ufabc.Ticketeria.service.TicketService;

@Controller
public class BuyTicketController {
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private TicketService ticketService;

	@RequestMapping("/comprarIngressoForm")
	public String buyTicketPage(Model model) {

		List<MovieVO> movies = movieService.getAll();
		model.addAttribute("dropDownItemsMovieTitle", movies);

		BuyTicketForm buyTicketForm = new BuyTicketForm();
		model.addAttribute("buyticketform", buyTicketForm);

		return "buyTicketForm";
	}

	@RequestMapping("/comprarIngresso")
	public String buyTicket(@ModelAttribute("buyticketform") BuyTicketForm buyTicketForm, Model model,
			HttpSession session) {

		// System.out.println(movieService.getById(buyTicketForm.getMovieId()).getTitle());

		MovieVO selectedMovie = movieService.getById(buyTicketForm.getMovieId()).get();

		TicketVO ticket = new TicketVO();
		ticket.setUser((UserVO) session.getAttribute("usuarioLogado"));
		ticket.setMovie(selectedMovie);
		ticketService.salvar(ticket);

		return "redirect:home";
	}
}
