package me.dcal.thermoconnect.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.dcal.thermoconnect.model.Species;
import me.dcal.thermoconnect.model.api.BodyConnexion;
import me.dcal.thermoconnect.model.api.BodySpecies;
import me.dcal.thermoconnect.model.api.BodyTerrarium;
import me.dcal.thermoconnect.service.ConnexionService;
import me.dcal.thermoconnect.service.SpeciesService;

@RestController
public class SpeciesController {
	@Autowired
	ConnexionService connexionService;
	
	@Autowired 
	SpeciesService speciesService;
	
	@PostMapping(path = "/getSpecies",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<BodySpecies> check(@RequestBody BodyConnexion bodyCo,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		if(connexionService.validUser(bodyCo.getLogin(), bodyCo.getPassword()))
			return speciesService.listSpecies();
		return null;
	}

}
