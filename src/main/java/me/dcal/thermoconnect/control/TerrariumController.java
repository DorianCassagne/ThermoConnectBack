package me.dcal.thermoconnect.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.dcal.thermoconnect.model.api.BodyAnimalData;
import me.dcal.thermoconnect.model.api.BodyConnexion;
import me.dcal.thermoconnect.model.api.BodyTerrarium;
import me.dcal.thermoconnect.model.api.BodyTerrariumData;
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
	public Integer ajoutTerrarium(@RequestBody BodyTerrarium bodyTerra,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		if(connexionService.validUser(bodyTerra.bodyConnexion)){
			if(terrariumService.addTerrarium(bodyTerra))
				return 1;
			return 0;
		}
		return -1;
	}
	
	@PostMapping(path = "/modifTerrarium",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Integer modifTerrarium(@RequestBody BodyTerrarium bodyTerra,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		if(connexionService.validUser(bodyTerra.bodyConnexion)){
			if(terrariumService.modifTerrarium(bodyTerra))
				return 1;
			return 0;
		}
		return -1;
	}
	
	
	
	@PostMapping(path = "/listTerrarium",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<BodyTerrarium> listTerrarium(@RequestBody BodyConnexion bc,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		if(connexionService.validUser(bc)){
			return terrariumService.getAllTerrarium(bc);
		}
		return null;

	}
	@PostMapping(path = "/deleteTerrarium",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public int deleteTerrarium(@RequestBody BodyTerrarium bt,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		if(connexionService.validUser(bt.bodyConnexion)){
			if(connexionService.isTerrariumUser(bt.bodyConnexion.getLogin(), bt.idTerrarium)) {
				terrariumService.deleteTerra(bt);
				return 1;
			}
			return 0;
		}
		return -1;

	}
	
	@PostMapping(path = "/addTerrariumData",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Integer addTerrariumdata(@RequestBody BodyTerrariumData body,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		if(connexionService.validUser(body.bodyConnexion)){
			if(connexionService.isTerrariumUser(body.bodyConnexion.getLogin(),body.idTerrarium)) {
				terrariumService.addDataTerrarium(body);
				return 1;
			}
			return 0;
		}
		return -1;
	}
	
	@PostMapping(path = "/getAllTerrariumData",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<BodyTerrariumData> getAllTerrariumdata(@RequestBody BodyTerrarium body,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		if(connexionService.validUser(body.bodyConnexion)){
			if(connexionService.isTerrariumUser(body.bodyConnexion.getLogin(),body.idTerrarium)) {
				return terrariumService.getAllData(body);
			}
		}
		return null;
	}
	@PostMapping(path = "/getLastTerrariumData",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public BodyTerrariumData getLastTerrariumdata(@RequestBody BodyTerrarium body,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		if(connexionService.validUser(body.bodyConnexion)){
			if(connexionService.isTerrariumUser(body.bodyConnexion.getLogin(),body.idTerrarium)) {
				return terrariumService.getLastData(body);
			}
		}
		return null;
	}
	@GetMapping(path = "/getLastTest")
	@ResponseBody
	public BodyTerrariumData getLastTest(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		BodyTerrarium bt = new BodyTerrarium();
		bt.idTerrarium = 2;
		return terrariumService.getLastData(bt);
	}

	
	
}
