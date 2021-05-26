package me.dcal.thermoconnect.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import me.dcal.thermoconnect.Factory;
import me.dcal.thermoconnect.id.AnimalPictureId;
import me.dcal.thermoconnect.model.Animal;
import me.dcal.thermoconnect.model.AnimalData;
import me.dcal.thermoconnect.model.AnimalPicture;
import me.dcal.thermoconnect.model.api.BodyAnimal;
import me.dcal.thermoconnect.model.api.BodyAnimalData;
import me.dcal.thermoconnect.repository.AnimalDataRepository;
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
	AnimalDataRepository animalDataRepository;
	@Autowired
	TerrariumRepository terrariumRepository;
	@Autowired
	Factory factory;
	
	
	public boolean addData(BodyAnimalData bodyAnimalData) {
		AnimalData a = factory.toEntity(bodyAnimalData);
		animalDataRepository.save(a);
		return true;
	}
	
	public Integer saveAnimal(BodyAnimal body, MultipartFile picture,List<MultipartFile> files) {
		Animal a = factory.toEntity(body);
		if(picture != null) {
			String fileName = picture.getOriginalFilename();
			a.setUrlPicture(fileName);
			fileService.saveAnimalImage(body.bodyConnexion.getLogin(), a.getIdAnimal(), picture, fileName);
		}
		a = animalRepository.save(a);
		if(files !=null) {
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
		}
		
		return 1;
	}
	
	public Integer saveDocument(BodyAnimal body,List<MultipartFile> files) {
		for (MultipartFile multipartFile : files) {
			AnimalPicture ap = new AnimalPicture();
			AnimalPictureId api = new AnimalPictureId();
			api.setIdAnimal(body.getIdAnimal());
			api.setNamePicture(multipartFile.getOriginalFilename());
			ap.setAnimalPictureId(api);
			ap.setUrl(multipartFile.getOriginalFilename());
			animalPictureRepository.save(ap);
			fileService.saveAnimalDocument(body.bodyConnexion.getLogin(), body.getIdAnimal(), multipartFile, multipartFile.getOriginalFilename());
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
	
	public List<BodyAnimalData> getAllData (BodyAnimal ba){
		Animal a = animalRepository.findById(ba.getIdAnimal()).get();
		List<BodyAnimalData> bads = new ArrayList();
		for(AnimalData ad : a.getAnimalDatas()) {
			bads.add(factory.toBody(ad));
		}
		return bads;
	}
	
	public int deleteDocument(BodyAnimal ba) {
		Animal a = animalRepository.findById(ba.getIdAnimal()).get();
		int count = 0;
		Set<AnimalPicture> ap =  a.getAnimalPictures();
		for (AnimalPicture animalPicture : ap) {
			if(ba.documents.contains(animalPicture.getAnimalPictureId().getNamePicture())) {
				animalPictureRepository.delete(animalPicture);
				count++;
			}
		}
		return count;
		
	}
	
//	public BodyAnimal getAnimal(int idAnimal) {
//		animalRepository.findById(idAnimal).get().getAnimalPictures();
//		return 
//		return null;
//	}
	
//	public List<Bo>
}
