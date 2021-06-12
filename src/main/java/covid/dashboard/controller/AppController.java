package covid.dashboard.controller;

import java.util.List;

import covid.dashboard.model.CovidDetails;
import covid.dashboard.model.Response;
import covid.dashboard.model.User;
import covid.dashboard.service.CovidDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class AppController {

	@Autowired CovidDashboardService service;

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());

		return "signup_form";
	}
	
	@PostMapping("/register_user")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		service.saveUser(user);
		
		return "register_success";
	}
	
	@GetMapping("/coviddashboard")
	public String getDashboard(Model model) {
		Response response = restTemplate.
			getForObject("https://corona-virus-stats.herokuapp.com/api/v1/cases/countries-search?limit=220",
			Response.class);

		List<CovidDetails> covidDetails = response.getData().getRows();

		int pageSize = 10;
		int pageNumbers = covidDetails.size() / pageSize;
		model.addAttribute("covidDetails", covidDetails);
		return "coviddashboard";
	}
}
