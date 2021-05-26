package me.dcal.thermoconnect.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dcal.thermoconnect.Factory;
import me.dcal.thermoconnect.model.Terrarium;
import me.dcal.thermoconnect.model.TerrariumData;
import me.dcal.thermoconnect.model.api.BodyConnexion;
import me.dcal.thermoconnect.model.api.BodySpecies;
import me.dcal.thermoconnect.model.api.BodyTerrarium;
import me.dcal.thermoconnect.model.api.BodyTerrariumData;
import me.dcal.thermoconnect.repository.TerrariumDataRepository;
import me.dcal.thermoconnect.repository.TerrariumRepository;
import me.dcal.thermoconnect.repository.UserRepository;

@Service
public class TerrariumService {
	@Autowired
	TerrariumRepository terrariumRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	TerrariumDataRepository terrariumDataRepository;
	@Autowired
	Factory factory;
	
	public boolean addDataTerrarium(BodyTerrariumData bt) {
		TerrariumData t = factory.toEntity(bt);
		terrariumDataRepository.save(t);
		return true;
	}
	
	public boolean addTerrarium(BodyTerrarium bt) {
		Terrarium t = factory.toEntity(bt);
		if(terrariumRepository.findAllByUsernameAndNameTerrarium(t.getUsername(),t.getNameTerrarium()).size() !=0)
			return false;
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
	
	public boolean deleteTerra(BodyTerrarium bt) {
		Terrarium t = terrariumRepository.findById(bt.idTerrarium).get();
		terrariumRepository.delete(t);
		return true;
	}
}
