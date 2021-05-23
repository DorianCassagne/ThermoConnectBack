package me.dcal.thermoconnect.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import me.dcal.thermoconnect.model.api.BodySpecies;

@Entity
@Table(name="species", schema = "thermoconnect")
public class Species {
	@Id
	@Column(name="species_name", unique=true)
	String speciesName;
	@Column(name="description")
	String description;

	@OneToMany( targetEntity=Animal.class, mappedBy="idSpecies" )
	private List<Animal> animals = new ArrayList<>();

	

	public Species() {

	}
	public String getSpeciesName() {
		return speciesName;
	}
	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}
