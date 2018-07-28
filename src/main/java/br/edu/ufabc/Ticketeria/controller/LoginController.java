package br.edu.ufabc.Ticketeria.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ufabc.Ticketeria.model.UserVO;
import br.edu.ufabc.Ticketeria.model.form.LoginForm;
import br.edu.ufabc.Ticketeria.model.form.SignUpForm;
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

		UserVO user = null;
		user = userService.findByUsernamePassword(loginForm.getUsername(), loginForm.getPassword());
		if (user != null) {
			// usuario existe, guardaremos ele na session
			session.setAttribute("usuarioLogado", user);
			user.setAuthenticated(true);
			//System.out.println("USUARIO DA SESSAO: " + session.getAttribute("usuarioLogado"));
			return "redirect:home";
		}
		// ele errou a senha, voltou para o formulario
		return "loginForm";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		try {
			UserVO user = (UserVO) session.getAttribute("usuarioLogado");
			user.setAuthenticated(false);
			session.invalidate();
			return "redirect:loginForm";
		} catch (Exception e) {
			return "error";
//			throw new RuntimeException("Nao foi possivel pegar o usuario da sessao.", e);
		}
	}
	
	@RequestMapping("/signup")
	public String signUp(Model model) {
		
		SignUpForm sigupmodel = new SignUpForm();
		model.addAttribute("signupform", sigupmodel);

		return "signUp";
	}
	
	@RequestMapping("/efetuaCadastro")
	public String efetuaCadastro(@ModelAttribute("signUpForm") SignUpForm signupForm, Model model) {

		SignUpForm signupModel = new SignUpForm();
		model.addAttribute("loginform", signupModel);

		UserVO user = new UserVO();
		user.setUsername(signupForm.getUsername());
		user.setPassword(signupForm.getPassword());
//		user = userService.findByUsernamePassword(loginForm.getUsername(), loginForm.getPassword());
		userService.salvar(user);
		// ele errou a senha, voltou para o formulario
		return "loginForm";
	}
}