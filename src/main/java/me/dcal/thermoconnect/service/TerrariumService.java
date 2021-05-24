package me.dcal.thermoconnect.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dcal.thermoconnect.Factory;
import me.dcal.thermoconnect.model.Terrarium;
import me.dcal.thermoconnect.model.api.BodyConnexion;
import me.dcal.thermoconnect.model.api.BodySpecies;
import me.dcal.thermoconnect.model.api.BodyTerrarium;
import me.dcal.thermoconnect.repository.TerrariumRepository;
import me.dcal.thermoconnect.repository.UserRepository;

@Service
public class TerrariumService {
	@Autowired
	TerrariumRepository terrariumRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	Factory factory;
	public boolean addTerrarium(BodyTerrarium bt) {
		Terrarium t = factory.toEntity(bt);
		terrariumRepository.save(t);
		return true;
	}
	
	public List<BodyTerrarium> getAllTerrarium(BodyConnexion bc){
		List<Terrarium> ts = terrariumRepository.findAllByUsername(userRepository.findById(bc.getLogin()));
		List<BodyTerrarium> bts = new ArrayList<>();
		for (Terrarium terrarium : ts) {
			bts.add(factory.toBody(terrarium));
		}
		
		return bts;
	}
	
}
