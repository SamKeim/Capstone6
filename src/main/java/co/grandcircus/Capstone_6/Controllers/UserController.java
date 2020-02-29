package co.grandcircus.Capstone_6.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.Capstone_6.Entities.User;
import co.grandcircus.Capstone_6.Repos.UserRepo;

@Controller
public class UserController {

	@Autowired
	private UserRepo uRepo;
	
	@Autowired
	private HttpSession sesh;
		
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@PostMapping("/login")
	public ModelAndView loginSubmit(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			RedirectAttributes redir
			) {
		User user = uRepo.findByUsernameIgnoreCase(username);
		
		if (user == null || !password.equals(user.getPassword())) {
			redir.addFlashAttribute("message", "Incorrect username or password.");
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		}
		
		sesh.setAttribute("user", user);
		redir.addFlashAttribute("message", "<h4 class=\"text-primary\">Welcome back " + user.getUsername() + "</h4>");
		return new ModelAndView("redirect:/tasks/");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(RedirectAttributes redir) {
		User user = (User)sesh.getAttribute("user");
		redir.addFlashAttribute("message", "<h4 class=\"text-success\">Successfully logged out, thank you " + user.getUsername() + ".</h4>");
		sesh.invalidate();
		return new ModelAndView("redirect:/login/");
	}
	
	@RequestMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("users/addUser");
	}
	
	@PostMapping("/register")
	public ModelAndView newUser(
			User newUser,
			@RequestParam("passwordConfirm") String passwordConfirm, 
			RedirectAttributes redir
			) {
		if (!passwordConfirm.equals(newUser.getPassword())) {
			redir.addFlashAttribute("message","<h4 class=\"text-danger\">Passwords do not match.</h4>");
			return new ModelAndView("redirect:/register");
		}
		User tester = uRepo.findByUsernameIgnoreCase(newUser.getUsername());
		if (tester != null) {
			redir.addFlashAttribute("message", "<h4 class=\"text-danger\">Username already exists.</h4>");
			return new ModelAndView("redirect:/register");
			//already exists
		}
		
		uRepo.save(newUser);
		redir.addFlashAttribute("message", "<h4 class=\"text-primary\">Welcome " + newUser.getUsername() +  "!</h4>");
		return new ModelAndView("redirect:/login");
	}
}
