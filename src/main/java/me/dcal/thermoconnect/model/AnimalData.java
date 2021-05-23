package me.dcal.thermoconnect.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import me.dcal.thermoconnect.id.AnimalDataId;
import me.dcal.thermoconnect.id.TerrariumDataId;

@Entity
@Table(name="animal_data", schema = "thermoconnect")
public class AnimalData {
	@EmbeddedId
	AnimalDataId animalDataId;
	@Column(name="weight")
	Double weight;
	
}
