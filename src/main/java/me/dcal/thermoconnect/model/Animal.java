package me.dcal.thermoconnect.model;


import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="animal", schema = "thermoconnect")
public class Animal {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="id_animal", unique=true)
	int idAnimal;
	@ManyToOne
	@JoinColumn(name="id_terrarium", nullable=false)
	Terrarium idTerrarium;
	@ManyToOne 
	@JoinColumn(name="id_species", nullable=false)
	Species idSpecies;
	@Column(name="name_animal")
	String nameAnimal;
	@Column(name="sex")
	boolean sex;
	@Column(name="date_of_birth")
	Date dateOfBirth;
	@Column(name="description")
	String description;
	@Column(name="text")
	String text;
	@Column(name="url_picture")
	String urlPicture;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "animalDataId.idAnimal")
	Set<AnimalData> animalDatas;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "animalPictureId.idAnimal")
	Set<AnimalPicture> animalPictures;

}
