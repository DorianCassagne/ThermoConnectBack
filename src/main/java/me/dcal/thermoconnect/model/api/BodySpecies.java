package me.dcal.thermoconnect.model.api;

import me.dcal.thermoconnect.model.Species;

public class BodySpecies {

    public String species;
    public String description;

    
   
    public BodySpecies(String espece, String description) {
        this.species = espece;
        this.description = description;
    }
   

    public String getSpeciesName() {
        return species;
    }

    public void setSpecies(String espece) {
        this.species = espece;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}