package me.dcal.thermoconnect.model.api;

import me.dcal.thermoconnect.model.Species;

public class BodySpecies {

    public String species;
    public String description;
    public Double humidity;
	public Double tempMin;
    public Double tempMax;
    

    
   
    public BodySpecies(String espece, String description, Double humidity, Double tempMin, Double tempMax) {
        this.species = espece;
        this.description = description;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax= tempMax;
    }
    
    public Double getHumidity() {
		return humidity;
	}


	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}


	public Double getTempMin() {
		return tempMin;
	}


	public void setTempMin(Double tempMin) {
		this.tempMin = tempMin;
	}


	public Double getTempMax() {
		return tempMax;
	}


	public void setTempMax(Double tempMax) {
		this.tempMax = tempMax;
	}


	public String getSpecies() {
		return species;
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