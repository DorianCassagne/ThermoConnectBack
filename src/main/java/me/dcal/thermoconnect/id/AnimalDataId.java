package me.dcal.thermoconnect.id;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AnimalDataId implements Serializable{
	@Column(name = "id_animal")
	Integer idAnimal;
	@Column(name="date_animal_data")
	Time dateAnimalData;
}
