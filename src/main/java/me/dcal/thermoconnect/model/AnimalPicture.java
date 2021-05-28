package me.dcal.thermoconnect.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import me.dcal.thermoconnect.id.AnimalPictureId;

@Entity
@Table(name="animal_picture", schema = "thermoconnect")
public class AnimalPicture {
	@EmbeddedId
	AnimalPictureId animalPictureId;
	public AnimalPictureId getAnimalPictureId() {
		return animalPictureId;
	}
	public void setAnimalPictureId(AnimalPictureId animalPictureId) {
		this.animalPictureId = animalPictureId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name="url")
	String url;
}


