package me.dcal.thermoconnect.id;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AnimalDataId implements Serializable{
	private static final long serialVersionUID = 1L;
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
