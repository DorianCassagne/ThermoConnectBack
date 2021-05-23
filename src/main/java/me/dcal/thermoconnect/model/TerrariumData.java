package me.dcal.thermoconnect.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import me.dcal.thermoconnect.id.TerrariumDataId;

@Entity
@Table(name="terrarium_data", schema = "thermoconnect")
//@IdClass(TerrariumDataId.class)
public class TerrariumData {
	
	@EmbeddedId
	TerrariumDataId terrariumDataId;
	


	@Column(name="temperature")
	double temperature;
	@Column(name="humidity")
	double humidity;
	
	public TerrariumData() {
		
	}
	
	public TerrariumDataId getTerrariumDataId() {
		return terrariumDataId;
	}

	public void setTerrariumDataId(TerrariumDataId terrariumDataId) {
		this.terrariumDataId = terrariumDataId;
	}
	
	public Terrarium getIdTerrarium() {
		return terrariumDataId.getIdTerrarium();
	}
	public void setIdTerrarium(Terrarium idTerrarium) {
		this.terrariumDataId.setIdTerrarium(idTerrarium);
	}
	public Time getTime() {
		return terrariumDataId.getTime();
	}
	public void setTime(Time time) {
		this.terrariumDataId.setTime(time);
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	
	
}
