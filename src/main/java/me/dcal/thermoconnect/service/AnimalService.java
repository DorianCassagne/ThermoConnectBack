package me.dcal.thermoconnect.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import me.dcal.thermoconnect.Factory;
import me.dcal.thermoconnect.id.AnimalPictureId;
import me.dcal.thermoconnect.model.Animal;
import me.dcal.thermoconnect.model.AnimalPicture;
import me.dcal.thermoconnect.model.api.BodyAnimal;
import me.dcal.thermoconnect.repository.AnimalPictureRepository;
import me.dcal.thermoconnect.repository.AnimalRepository;
import me.dcal.thermoconnect.repository.TerrariumRepository;

@Service
public class AnimalService {
	@Autowired
	FileService fileService;
	@Autowired
	AnimalRepository animalRepository;
	@Autowired
	AnimalPictureRepository animalPictureRepository;
	@Autowired
	TerrariumRepository terrariumRepository;
	@Autowired
	Factory factory;
	
	public Integer saveAnimal(BodyAnimal body, MultipartFile picture,List<MultipartFile> files) {
		Animal a = factory.toEntity(body);
		String fileName = picture.getOriginalFilename();
		a.setUrlPicture(fileName);
		a = animalRepository.save(a);
		fileService.saveAnimalImage(body.bodyConnexion.getLogin(), a.getIdAnimal(), picture, fileName);
		for (MultipartFile multipartFile : files) {
			AnimalPicture ap = new AnimalPicture();
			AnimalPictureId api = new AnimalPictureId();
			api.setIdAnimal(a.getIdAnimal());
			api.setNamePicture(multipartFile.getOriginalFilename());
			ap.setAnimalPictureId(api);
			ap.setUrl(multipartFile.getOriginalFilename());
			animalPictureRepository.save(ap);
			fileService.saveAnimalDocument(body.bodyConnexion.getLogin(), a.getIdAnimal(), multipartFile, multipartFile.getOriginalFilename());
		}
		
		return 1;
	}
	
	
	public List<BodyAnimal> getAnnimalOfTerra(int terrarium){
		List<Animal> la = animalRepository.findAllByidTerrarium(terrariumRepository.findById(terrarium).get());
		List<BodyAnimal> lba = new ArrayList<>();
		for (Animal animal : la) {
			lba.add(factory.toEntity(animal));
		}
		return lba;
	}
	
	public BodyAnimal getAnimal(int idAnimal) {
		animalRepository.findById(idAnimal).get().getAnimalPictures();
		
		return null;
	}
	
//	public List<Bo>
}
