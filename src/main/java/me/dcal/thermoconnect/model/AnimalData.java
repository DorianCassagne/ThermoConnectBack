package me.dcal.thermoconnect.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import me.dcal.thermoconnect.id.AnimalDataId;

@Entity
@Table(name="animal_data", schema = "thermoconnect")
public class AnimalData {
	@EmbeddedId
	AnimalDataId animalDataId;
	@Column(name="weight")
	Double weight;
	

	public AnimalDataId getAnimalDataId() {
		return animalDataId;
	}
	public void setAnimalDataId(AnimalDataId animalDataId) {
		this.animalDataId = animalDataId;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
}
