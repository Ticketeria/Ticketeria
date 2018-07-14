package br.edu.ufabc.Ticketeria.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ufabc.Ticketeria.model.form.LoginForm;
import br.edu.ufabc.Ticketeria.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/loginForm")
	public String loginForm(Model model) {
		
		LoginForm loginModel = new LoginForm();
		model.addAttribute("loginform", loginModel);
		
		return "loginForm";
	}

	@RequestMapping("/efetuaLogin")
	public String efetuaLogin(@ModelAttribute("loginForm") LoginForm loginForm, HttpSession session, Model model) {
		
		LoginForm loginModel = new LoginForm();
		model.addAttribute("loginform", loginModel);
		
		if (userService.findByUsernamePassword(loginForm.getUsername(), loginForm.getPassword()) != null) {
			// usuario existe, guardaremos ele na session
			session.setAttribute("usuarioLogado", userService.findByUsernamePassword(loginForm.getUsername(), loginForm.getPassword()));
			return "redirect:home";
		}
		// ele errou a senha, voltou para o formulario
		return "loginForm";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
	  session.invalidate();
	  return "redirect:loginForm";
	}
}