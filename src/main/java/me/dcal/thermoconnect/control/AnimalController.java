package me.dcal.thermoconnect.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import me.dcal.thermoconnect.Factory;
import me.dcal.thermoconnect.model.Animal;
import me.dcal.thermoconnect.model.Terrarium;
import me.dcal.thermoconnect.model.api.BodyAnimal;
import me.dcal.thermoconnect.model.api.BodyTerrarium;
import me.dcal.thermoconnect.repository.AnimalRepository;
import me.dcal.thermoconnect.service.AnimalService;
import me.dcal.thermoconnect.service.ConnexionService;
import me.dcal.thermoconnect.service.FileService;

@RestController
public class AnimalController {
	@Autowired
	FileService fileService;
	@Autowired
	ConnexionService connexionService;
	@Autowired
	AnimalService animalService;
	
	
//	@Autowired
//	AnimalRepository animalRepository;
//	@Autowired
//	AnimalRepository animalRepository;
	
	@PostMapping(path = "/ajoutAnimal",consumes = {MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
	@ResponseBody
	public Integer ajoutAnimal(@RequestPart("description")  BodyAnimal body,@RequestPart("files") List<MultipartFile> files
			,@RequestPart("picture") MultipartFile picture, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		if(connexionService.validUser(body.bodyConnexion)){
			if(connexionService.isTerrariumUser(body.bodyConnexion.getLogin(),body.terrarium)) {
				animalService.saveAnimal(body, picture, files);
				return 1;
			}
			return 0;
		}
		return -1;
	}
	
	@PostMapping(path = "/listAnimal",consumes = {MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
	@ResponseBody
	public List<BodyAnimal> listAnimal(@RequestPart("description")  BodyTerrarium body,@RequestPart("files") List<MultipartFile> files
			,@RequestPart("picture") MultipartFile picture, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		if(connexionService.validUser(body.bodyConnexion)){
			if(connexionService.isTerrariumUser(body.bodyConnexion.getLogin(),body.idTerrarium)) {
				return animalService.getAnnimalOfTerra(body.idTerrarium);
			}
			return null;
		}
		return null;
	}
	
//	@PostMapping(path = "/listAnimalDocument",consumes = {MediaType.APPLICATION_JSON_VALUE,
//			MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
//	@ResponseBody
//	public List<BodyAnimal> listAnimalDocuemnt(@RequestPart("description")  BodyAnimal body,@RequestPart("files") List<MultipartFile> files
//			,@RequestPart("picture") MultipartFile picture, HttpServletRequest request,
//			HttpServletResponse response, Model model) {
//		
//		if(connexionService.validUser(body.bodyConnexion)){
//			
//			
////			if(connexionService.isTerrariumUser(body.bodyConnexion.getLogin(),body.idTerrarium)) {
//////				return animalService.getAnnimalOfTerra(body.idTerrarium);
////			}
////			return null;
//		}
//		return null;
//	}
	
	
	


}
