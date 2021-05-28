package me.dcal.thermoconnect.control;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import me.dcal.thermoconnect.model.api.BodyAnimal;
import me.dcal.thermoconnect.model.api.BodyAnimalData;
import me.dcal.thermoconnect.model.api.BodyTerrarium;
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
	
	

	
	@PostMapping(path = "/ajoutAnimal",consumes = {MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
	@ResponseBody
	public Integer ajoutAnimal(@RequestPart("description")  BodyAnimal body,@RequestPart(name = "files", required = false) List<MultipartFile> files
			,@RequestPart(name = "picture",required = false) MultipartFile picture, HttpServletRequest request,
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
	
	@PostMapping(path = "/deleteAnimal",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Integer deleteAnimal(@RequestBody BodyAnimal body,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		if(connexionService.validUser(body.bodyConnexion)){
			if(connexionService.isAnimalUser(body.bodyConnexion.getLogin(),body.idAnimal)) {
				return (fileService.deleteAnimal(body))?1:0;
			}
			return 0;
		}
		return -1;
		
	}
	@PostMapping(path = "/ajoutDocument",consumes = {MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
	@ResponseBody
	public Integer ajoutDocument(@RequestPart("description")  BodyAnimal body,@RequestPart("files") List<MultipartFile> files,
			HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		if(connexionService.validUser(body.bodyConnexion)){
			if(connexionService.isTerrariumUser(body.bodyConnexion.getLogin(),body.terrarium)) {
				animalService.saveDocument(body, files);
				return 1;
			}
			return 0;
		}
		return -1;
	}
	
	@PostMapping(path = "/deleteDocument",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = "application/json")
	@ResponseBody
	public Integer deleteDocument(@RequestBody  BodyAnimal body,
			HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		if(connexionService.validUser(body.bodyConnexion)){
			if(connexionService.isAnimalUser(body.bodyConnexion.getLogin(), body.getIdAnimal())) {
				return animalService.deleteDocument(body);
			}
			return 0;
		}
		return -1;
	}
	
	@PostMapping(path = "/listAnimal",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = "application/json")
	@ResponseBody
	public List<BodyAnimal> listAnimal(@RequestBody  BodyTerrarium body, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		if(connexionService.validUser(body.bodyConnexion)){
			if(connexionService.isTerrariumUser(body.bodyConnexion.getLogin(),body.idTerrarium)) {
				return animalService.getAnnimalOfTerra(body.idTerrarium);
			}
			return null;
		}
		return null;
	}
	
	@PostMapping(path = "/getAnimalImage",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public FileSystemResource getAnimalImage(@RequestBody BodyAnimal body,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		if(connexionService.validUser(body.bodyConnexion)){
			if(connexionService.isAnimalUser(body.bodyConnexion.getLogin(),body.idAnimal)) {
				return fileService.getAnimalImage(body);
			}
		}
		return null;
		
	}
	
	@PostMapping(path = "/getAnimalDocument",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public FileSystemResource getAnimalDocument(@RequestBody BodyAnimal body,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		if(connexionService.validUser(body.bodyConnexion)){
			if(connexionService.isAnimalUser(body.bodyConnexion.getLogin(),body.idAnimal)) {
				return fileService.getAnimalDocument(body);
			}
		}
		return null;
		
	}
	@PostMapping(path = "/addAnimalData",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public int getAnimalData(@RequestBody BodyAnimalData body,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		if(connexionService.validUser(body.bodyConnexion)){
			if(connexionService.isAnimalUser(body.bodyConnexion.getLogin(),body.id)) {
				animalService.addData(body);
				return 1;
			}
			return 0;
		}
		return -1;
	}
	@PostMapping(path = "/getAllAnimalData",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Set<BodyAnimalData> getAllAnimalData(@RequestBody BodyAnimal body,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		if(connexionService.validUser(body.bodyConnexion)){
			if(connexionService.isAnimalUser(body.bodyConnexion.getLogin(),body.idAnimal)) {
				animalService.getAllData(body);
			}
		}
		return null;
	}
	@PostMapping(path = "/getLastAnimalData",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public BodyAnimalData getLastAnimalData(@RequestBody BodyAnimal body,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		if(connexionService.validUser(body.bodyConnexion)){
			if(connexionService.isAnimalUser(body.bodyConnexion.getLogin(),body.idAnimal)) {
				return animalService.getLastData(body);
			}
		}
		return null;
	}
	

	
	


}
