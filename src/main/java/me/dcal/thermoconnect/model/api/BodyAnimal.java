package me.dcal.thermoconnect.model.api;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BodyAnimal {

	    public List<String> getDocuments() {
		return documents;
	}
	public void setDocuments(List<String> documents) {
		this.documents = documents;
	}
		public BodyConnexion bodyConnexion;
	    public Integer idAnimal;
	    public Integer terrarium;
	    public BodySpecies species;
	    public String name;
	    public Boolean sex;
	    public String dateOfBirth;
		public String description;
	    public String food;
	    public List<String> documents = new ArrayList<>(); 


	    public BodyAnimal() {
	    	
	    }
	    public BodyAnimal(BodyConnexion bodyConnexion, Integer terrarium, BodySpecies species, String name, Boolean sex, String dateOfBirth, String description,   String food, Integer idAnimal) {
	        this.bodyConnexion = bodyConnexion;
	        this.idAnimal = idAnimal;
	        this.terrarium = terrarium;
	        this.species = species;
	        this.name = name;
	        this.sex = sex;
	        this.dateOfBirth = dateOfBirth;
	        this.description = description;
	        this.food = food;
	    }


	    public BodyConnexion getBodyConnexion() {
	        return bodyConnexion;
	    }

	    public void setBodyConnexion(BodyConnexion bodyConnexion) {
	        this.bodyConnexion = bodyConnexion;
	    }


	    public Integer getIdAnimal() {
	        return idAnimal;
	    }

	    public void setIdAnimal(Integer idAnimal) {
	        this.idAnimal = idAnimal;
	    }

	    public Integer getTerrarium() {
	        return terrarium;
	    }

	    public void setTerrarium(Integer terrarium) {
	        this.terrarium = terrarium;
	    }

	    public BodySpecies getSpecies() {
	        return species;
	    }

	    public void setSpecies(BodySpecies species) {
	        this.species = species;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Boolean isSex() {
	        return sex;
	    }

	    public void setSex(Boolean sex) {
	        this.sex = sex;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getFood() {
	        return food;
	    }

	    public void setFood(String food) {
	        this.food = food;
	    }
	    public String getDateOfBirth() {
 			return dateOfBirth;
 		}
 		public void setDateOfBirth(String dateOfBirth) {
 			this.dateOfBirth = dateOfBirth;
 		}
	 
	  

}
