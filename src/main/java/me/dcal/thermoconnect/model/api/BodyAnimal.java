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
	    public String species;
	    public String name;
	    public Boolean sex;
	    public String dateOfBirth;
		public String description;
	    public String food;
	    public List<String> documents = new ArrayList<>();


	    public BodyAnimal() {
	    	
	    }
	    public BodyAnimal(BodyConnexion bodyConnexion, int terrarium, String species, String name, boolean sex, String dateOfBirth, String description,   String food, int idAnimal) {
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


	    public int getIdAnimal() {
	        return idAnimal;
	    }

	    public void setIdAnimal(int idAnimal) {
	        this.idAnimal = idAnimal;
	    }

	    public int getTerrarium() {
	        return terrarium;
	    }

	    public void setTerrarium(int terrarium) {
	        this.terrarium = terrarium;
	    }

	    public String getSpecies() {
	        return species;
	    }

	    public void setSpecies(String species) {
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

	    public void setSex(boolean sex) {
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
