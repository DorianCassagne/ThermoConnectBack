package me.dcal.thermoconnect.model.api;



public class BodyAnimal {

	    public BodyConnexion bodyConnexion;
	    public int idAnimal;
	    public int terrarium;
	    public String species;
	    public String name;
	    public boolean sexe;
	    public String datenaissance;
	    public String description;
	    public String food;


	    public BodyAnimal(BodyConnexion bodyConnexion, int terrarium, String species, String name, boolean sexe, String datenaissance, String description,   String food, int idAnimal) {
	        this.bodyConnexion = bodyConnexion;
	        this.idAnimal = idAnimal;
	        this.terrarium = terrarium;
	        this.species = species;
	        this.name = name;
	        this.sexe = sexe;
	        this.datenaissance = datenaissance;
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

	    public boolean isSexe() {
	        return sexe;
	    }

	    public void setSexe(boolean sexe) {
	        this.sexe = sexe;
	    }

	    public String getDatenaissance() {
	        return datenaissance;
	    }

	    public void setDatenaissance(String datenaissance) {
	        this.datenaissance = datenaissance;
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

	 
	  

}
