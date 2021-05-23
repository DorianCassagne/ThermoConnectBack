package me.dcal.thermoconnect.model.api;

import me.dcal.thermoconnect.model.Species;

public class BodySpecies {

    public String espece;
    public String description;

    
   
    public BodySpecies(String espece, String description) {
        this.espece = espece;
        this.description = description;
    }
   

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}