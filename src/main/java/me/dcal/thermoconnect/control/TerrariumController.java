package me.dcal.thermoconnect.control;

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
import me.dcal.thermoconnect.service.TerrariumService;
@RestController
public class TerrariumController {
	@Autowired
	TerrariumService terrariumService;
	
	@PostMapping(path = "/ajoutTerrarium",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Integer check(@RequestBody BodyTerrarium bodyTerra,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		
//		terrariumService.addTerrarium(bodyTerra.bodyConnexion.getLogin(),
//				bodyTerra.nameTerrarium, sizeTerrarium, startTime, stopTime, temperatureMax, temperatureMin)
		return (bodyTerra.bodyConnexion.getLogin().equals("test") && bodyTerra.bodyConnexion.getPassword().equals("test") && bodyTerra.size.equals("1"))?1:0  ;

	}
}
