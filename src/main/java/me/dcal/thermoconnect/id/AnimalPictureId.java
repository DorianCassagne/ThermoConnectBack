package me.dcal.thermoconnect.id;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AnimalPictureId implements Serializable{
	@Column(name = "id_animal")
	String idAnimal;
	@Column(name="name_picture")
	String namePicture;
}
