package me.dcal.thermoconnect.id;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AnimalPictureId implements Serializable{
	@Column(name = "id_animal")
	Integer idAnimal;
	@Column(name="name_picture")
	String namePicture;
	public Integer getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(Integer idAnimal) {
		this.idAnimal = idAnimal;
	}
	public String getNamePicture() {
		return namePicture;
	}
	public void setNamePicture(String namePicture) {
		this.namePicture = namePicture;
	}
}
