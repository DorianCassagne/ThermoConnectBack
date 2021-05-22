package me.dcal.thermoconnect.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="species", schema = "thermoconnect")
public class Species {
@Id
@Column(name="speciesName", unique=true)
String speciesName;
@Column(name="description")
String description;
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
