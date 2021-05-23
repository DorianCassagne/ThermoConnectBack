package me.dcal.thermoconnect.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dcal.thermoconnect.model.Species;
import me.dcal.thermoconnect.model.api.BodySpecies;
import me.dcal.thermoconnect.repository.SpeciesRepository;

@Service
public class SpeciesService {
	@Autowired
	SpeciesRepository speciesRepository;
	
	public List<BodySpecies> listSpecies(){
		List<Species> lspe =  speciesRepository.findAll();
		List<BodySpecies> listBody = new ArrayList<>();
		for (Species species : lspe) {
			listBody.add(species.toBody());
		}
		return listBody;
	}
}