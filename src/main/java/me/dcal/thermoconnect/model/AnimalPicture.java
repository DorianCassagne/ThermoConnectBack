package me.dcal.thermoconnect.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import me.dcal.thermoconnect.id.AnimalDataId;
import me.dcal.thermoconnect.id.AnimalPictureId;

@Entity
@Table(name="animal_picture", schema = "thermoconnect")
public class AnimalPicture {
	@EmbeddedId
	AnimalPictureId animalPictureId;
	@Column(name="url")
	String url;
}


