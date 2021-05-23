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

import me.dcal.thermoconnect.model.api.BodyConnexion;
import me.dcal.thermoconnect.model.api.BodyTerrarium;
import me.dcal.thermoconnect.service.ConnexionService;
import me.dcal.thermoconnect.service.TerrariumService;
@RestController
public class TerrariumController {
	@Autowired
	TerrariumService terrariumService;
	@Autowired
	ConnexionService connexionService;
	
	@PostMapping(path = "/ajoutTerrarium",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Integer check(@RequestBody BodyTerrarium bodyTerra,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		if(connexionService.validUser(bodyTerra.bodyConnexion)){
			terrariumService.addTerrarium(bodyTerra);
			return 1;
		}
		return 0;

	}
	@PostMapping(path = "/listTerrarium",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<BodyTerrarium> check(@RequestBody BodyConnexion bc,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		if(connexionService.validUser(bc)){
			return terrariumService.getAllTerrarium(bc);
		}
		return null;

	}
}
