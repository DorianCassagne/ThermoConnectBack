package me.dcal.thermoconnect.id;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AnimalDataId implements Serializable{
	@Column(name = "id_animal")
	Integer idAnimal;
	@Column(name="date_animal_data")
	Date dateAnimalData;

	public Integer getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(Integer idAnimal) {
		this.idAnimal = idAnimal;
	}
	public Date getDateAnimalData() {
		return dateAnimalData;
	}
	public void setDateAnimalData(Date dateAnimalData) {
		this.dateAnimalData = dateAnimalData;
	}
}
