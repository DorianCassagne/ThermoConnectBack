package me.dcal.thermoconnect.service;

import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dcal.thermoconnect.model.Terrarium;
import me.dcal.thermoconnect.repository.TerrariumRepository;
import me.dcal.thermoconnect.repository.UserRepository;

@Service
public class TerrariumService {
	@Autowired
	TerrariumRepository terrariumRepository;
	@Autowired
	UserRepository userRepository;
	public boolean addTerrarium(String username, String nameTerrarium, String sizeTerrarium, 
			Time startTime,Time stopTime,double temperatureMax,double temperatureMin) {
		Terrarium t = new Terrarium();
		t.setUsername(userRepository.getOne(username));
		t.setStartLightTime(startTime);
		t.setStopLightTime(stopTime);
		t.setTemperatureMax(temperatureMax);
		t.setTemperatureMin(temperatureMin);
		t.setSize(sizeTerrarium);
		terrariumRepository.save(t);
		return true;
	}
	
}
