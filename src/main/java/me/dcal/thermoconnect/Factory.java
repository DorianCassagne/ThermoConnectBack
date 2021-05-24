package me.dcal.thermoconnect;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dcal.thermoconnect.model.Animal;
import me.dcal.thermoconnect.model.AnimalData;
import me.dcal.thermoconnect.model.AnimalPicture;
import me.dcal.thermoconnect.model.Species;
import me.dcal.thermoconnect.model.Terrarium;
import me.dcal.thermoconnect.model.api.BodyAnimal;
import me.dcal.thermoconnect.model.api.BodyConnexion;
import me.dcal.thermoconnect.model.api.BodySpecies;
import me.dcal.thermoconnect.model.api.BodyTerrarium;
import me.dcal.thermoconnect.repository.AnimalRepository;
import me.dcal.thermoconnect.repository.SpeciesRepository;
import me.dcal.thermoconnect.repository.TerrariumRepository;
import me.dcal.thermoconnect.repository.UserRepository;

@Service
public class Factory {

	@Autowired
	UserRepository userRepository;
	@Autowired
	AnimalRepository animalRepository;
	@Autowired
	SpeciesRepository speciesRepository;
	@Autowired
	TerrariumRepository terrariumRepository;

	@Autowired
	Factory factory;

	public Factory() {
	}

	private Date stringToDate(String date) {
		try {
			return new Date( new SimpleDateFormat("dd/MM/yyyy").parse(date).getTime());
		} catch (Exception e) {
			System.out.println("Bad date value : "+ date);
			return null;
		}
	}
	private Time stringToTime(String time) {
		return java.sql.Time.valueOf(time);
	}

	public Animal toEntity(BodyAnimal ba) {
		Animal a = new Animal(); 
		a.setDateOfBirth(stringToDate(ba.dateOfBirth));
		a.setDescription(ba.description);
		if(speciesRepository.findById(ba.species).isPresent())
			a.setSpecies(speciesRepository.findById(ba.species).get());
		else {
			throw new RuntimeException();
		}
		a.setIdTerrarium(terrariumRepository.findById(ba.terrarium).get());
		a.setNameAnimal(ba.name);
		a.setSex(ba.sex);
		a.setFood(ba.food);
		return a;

	}
	public BodyAnimal toEntity(Animal a) {
		BodyAnimal ba = new BodyAnimal(new BodyConnexion(), 
				a.getIdTerrarium().getIdTerrarium(),
				a.getSpecies().getSpeciesName(), a.getNameAnimal(), a.getSex(), a.getDateOfBirth().toString(), a.getDescription(),
				a.getFood(), a.getIdAnimal());
		
		for(AnimalPicture ad :a.getAnimalPictures()) {
			ba.getDocuments().add(ad.getAnimalPictureId().getNamePicture());
//			getDocuments
//			this.toBody(ad)
		}
//		ba.getDocuments().addAll(a.getAnimalDatas());	
		return ba;
	}

	public BodySpecies toBody(Species s) {
		return new BodySpecies(s.getSpeciesName(),s.getDescription());
	}
	public Species toEntity(BodySpecies bs) {
		Species s = new Species();
		s.setSpeciesName(bs.getSpeciesName());
		s.setDescription(bs.getDescription());
		return s;
	}

	public BodyTerrarium toBody(Terrarium t) {
		BodyTerrarium bt = new BodyTerrarium();
		bt.nameTerrarium=t.getNameTerrarium();
		bt.sizeTerrarium=t.getSizeTerrarium();
		if(t.getStartLightTime()!=null)
			bt.startLightTime=t.getStartLightTime().toString();
		if(t.getStopLightTime()!=null)
			bt.stopLightTime=t.getStopLightTime().toString();
		bt.temperatureMax=t.getTemperatureMax();
		bt.temperatureMin=t.getTemperatureMin();
		bt.idTerrarium=t.getIdTerrarium();
		bt.humidityTerrarium=t.getHumidityTerrarium();
		return bt;
	}
	public Terrarium toEntity(BodyTerrarium bt) {
		Terrarium t = new Terrarium();
		t.setUsername(userRepository.getOne(bt.bodyConnexion.getLogin()));
		t.setNameTerrarium(bt.nameTerrarium);
		t.setSizeTerrarium(bt.sizeTerrarium);
		if(bt.startLightTime!=null)
			t.setStartLightTime(stringToTime(bt.startLightTime));
		if(bt.stopLightTime!=null)
			t.setStopLightTime(stringToTime(bt.stopLightTime));
		t.setTemperatureMax(bt.temperatureMax);
		t.setTemperatureMin(bt.temperatureMin);
		t.setHumidityTerrarium(bt.humidityTerrarium);

		return t;
	}



}
