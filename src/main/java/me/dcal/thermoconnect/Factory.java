package me.dcal.thermoconnect;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dcal.thermoconnect.model.Animal;
import me.dcal.thermoconnect.model.Species;
import me.dcal.thermoconnect.model.Terrarium;
import me.dcal.thermoconnect.model.api.BodyAnimal;
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
	public BodySpecies toBody(Species s) {
		return new BodySpecies(s.getSpeciesName(),s.getDescription());
	}
	public Species toEntity(BodySpecies bs) {
		Species s = new Species();
		s.setSpeciesName(bs.getSpeciesName());
		s.setDescription(bs.getDescription());
		return s;
	}
	
	public Animal toEntity(BodyAnimal ba) {
		Animal a = new Animal(); 
		try {
			a.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(ba.dateOfBirth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		a.setDescription(ba.description);
		if(speciesRepository.findById(ba.species).isPresent())
			a.setSpecies(speciesRepository.findById(ba.species).get());
		else {
			throw new RuntimeException();
		}
		a.setIdTerrarium(terrariumRepository.findById(ba.terrarium).get());
		a.setNameAnimal(ba.name);
		a.setSex(ba.sex);
		return a;
		
	}

	public BodyTerrarium toBody(Terrarium t) {
		BodyTerrarium bt = new BodyTerrarium();
		bt.nameTerrarium=t.getNameTerrarium();
		bt.sizeTerrarium=t.getSizeTerrarium();
		bt.startLightTime=t.getStartLightTime();
		bt.stopLightTime=t.getStartLightTime();
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
		t.setStartLightTime(bt.startLightTime);
		t.setStopLightTime(bt.stopLightTime);
		t.setTemperatureMax(bt.temperatureMax);
		t.setTemperatureMin(bt.temperatureMin);
		t.setHumidityTerrarium(bt.humidityTerrarium);

		return t;
	}



}
