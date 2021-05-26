package me.dcal.thermoconnect.model;


import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="animal", schema = "thermoconnect")
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_animal", unique=true)
	Integer idAnimal;
	@ManyToOne
	@JoinColumn(name="id_terrarium", nullable=false)
	Terrarium idTerrarium;
	@ManyToOne 
	@JoinColumn(name="species_name", nullable=false)
	Species species;
	@Column(name="name_animal")
	String nameAnimal;
	@Column(name="sex")
	Boolean sex;
	@Column(name="date_of_birth")
	Date dateOfBirth;
	@Column(name="description")
	String description;
	@Column(name="url_picture")
	String urlPicture;
	@Column(name="food")
	String food;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "animalDataId.idAnimal")
	Set<AnimalData> animalDatas;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "animalPictureId.idAnimal")
	Set<AnimalPicture> animalPictures;

	
	public Integer getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(Integer idAnimal) {
		this.idAnimal = idAnimal;
	}
	public Terrarium getIdTerrarium() {
		return idTerrarium;
	}
	public void setIdTerrarium(Terrarium idTerrarium) {
		this.idTerrarium = idTerrarium;
	}
	public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species idSpecies) {
		this.species = idSpecies;
	}
	public String getNameAnimal() {
		return nameAnimal;
	}
	public void setNameAnimal(String nameAnimal) {
		this.nameAnimal = nameAnimal;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date date) {
		this.dateOfBirth = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrlPicture() {
		return urlPicture;
	}
	public void setUrlPicture(String urlPicture) {
		this.urlPicture = urlPicture;
	}
	public Set<AnimalData> getAnimalDatas() {
		return animalDatas;
	}
	public void setAnimalDatas(Set<AnimalData> animalDatas) {
		this.animalDatas = animalDatas;
	}
	public Set<AnimalPicture> getAnimalPictures() {
		return animalPictures;
	}
	public void setAnimalPictures(Set<AnimalPicture> animalPictures) {
		this.animalPictures = animalPictures;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
}
