package me.dcal.thermoconnect.control;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import me.dcal.thermoconnect.model.api.BodyConnexion;
import me.dcal.thermoconnect.service.ConnexionService;



@RestController
public class UserController {
	@Autowired
	public ConnexionService connexionService;
	
	@PostMapping(path = "/connexion",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Boolean connexion(@RequestBody BodyConnexion body,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return connexionService.validUser(body.getLogin(), body.getPassword());
		
	}
	
	@PostMapping(path = "/createuser",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Boolean createUser(@RequestBody BodyConnexion body,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return connexionService.createUser(body.getLogin(), body.getPassword());
		
	}
	
	
//	@GetMapping("/connexions")
//	@ResponseBody
//	public Boolean check( Model model) {
//		User u = myuserrepo.findAll().get(0);
//		System.out.println(u.getPassword());
//		return true  ;
//		
//	}
	



}
