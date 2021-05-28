package me.dcal.thermoconnect.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dcal.thermoconnect.Factory;
import me.dcal.thermoconnect.model.Species;
import me.dcal.thermoconnect.model.api.BodySpecies;
import me.dcal.thermoconnect.repository.SpeciesRepository;

@Service
public class SpeciesService {
	@Autowired
	SpeciesRepository speciesRepository;
	@Autowired
	Factory factory;
	
	public List<BodySpecies> listSpecies(){
		List<Species> lspe =  speciesRepository.findAll();
		List<BodySpecies> listBody = new ArrayList<>();
		for (Species species : lspe) {
			listBody.add(factory.toBody(species));
		}
		return listBody;
	}
	
	public boolean addSpecies(Species s){
		speciesRepository.save(s);
		return true;
	}
}
