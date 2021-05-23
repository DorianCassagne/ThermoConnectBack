package me.dcal.thermoconnect;

import org.springframework.beans.factory.annotation.Autowired;

import me.dcal.thermoconnect.model.Species;
import me.dcal.thermoconnect.model.Terrarium;
import me.dcal.thermoconnect.model.api.BodySpecies;
import me.dcal.thermoconnect.model.api.BodyTerrarium;
import me.dcal.thermoconnect.repository.AnimalRepository;
import me.dcal.thermoconnect.repository.UserRepository;

public class Factory {

	@Autowired
	UserRepository userRepository;
	@Autowired
	AnimalRepository animalRepository;
	
	public static final Factory factory = new Factory();

	public BodySpecies toBody(Species s) {
		return new BodySpecies(s.getSpeciesName(),s.getDescription());
	}
	public Species toEntity(BodySpecies bs) {
		Species s = new Species();
		s.setSpeciesName(s.getSpeciesName());
		s.setSpeciesName(bs.getDescription());
		return s;
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
