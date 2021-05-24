package me.dcal.thermoconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import me.dcal.thermoconnect.Factory;
import me.dcal.thermoconnect.model.Animal;
import me.dcal.thermoconnect.model.api.BodyAnimal;
import me.dcal.thermoconnect.repository.AnimalRepository;

@Service
public class AnimalService {
	@Autowired
	FileService fileService;
	@Autowired
	AnimalRepository animalRepository;
	@Autowired
	Factory factory;
	
	public Integer saveAnimal(BodyAnimal body, MultipartFile picture,List<MultipartFile> files) {
		Animal a = factory.toEntity(body);
		String fileName = picture.getOriginalFilename();
		fileService.saveAnimalImage(body.bodyConnexion.getLogin(), body.getIdAnimal(), picture, fileName);
		a.setUrlPicture(fileName);
		animalRepository.save(a);
		
		//TODO:document
		
		for (MultipartFile multipartFile : files) {
			//todo creer et sauver les animalpicture
			fileService.saveAnimalDocument(body.bodyConnexion.getLogin(), body.getIdAnimal(), multipartFile, multipartFile.getOriginalFilename());
		}
		
		return 1;
	}
}
