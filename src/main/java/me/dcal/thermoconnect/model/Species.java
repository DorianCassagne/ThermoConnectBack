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
	@Column(name="humidity_species")
    Double humiditySpecies;
	@Column(name="temperature_min_species")
    Double temperatureMinSpecies;
	@Column(name="temperature_max_species")
    Double temperatureMaxSpecies;


	@OneToMany( targetEntity=Animal.class, mappedBy="species" )
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
	public Double getHumiditySpecies() {
		return humiditySpecies;
	}
	public void setHumiditySpecies(Double humiditySpecies) {
		this.humiditySpecies = humiditySpecies;
	}
	public Double getTemperatureMinSpecies() {
		return temperatureMinSpecies;
	}
	public void setTemperatureMinSpecies(Double temperatureMinSpecies) {
		this.temperatureMinSpecies = temperatureMinSpecies;
	}
	public Double getTemperatureMaxSpecies() {
		return temperatureMaxSpecies;
	}
	public void setTemperatureMaxSpecies(Double temperatureMaxSpecies) {
		this.temperatureMaxSpecies = temperatureMaxSpecies;
	}


}
