package me.dcal.thermoconnect.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import me.dcal.thermoconnect.id.TerrariumDataId;

@Entity
@Table(name="terrariumdata", schema = "thermoconnect")
@IdClass(TerrariumDataId.class)
public class TerrariumData {
	@Id
	@ManyToOne
	@JoinColumn(name = "idTerrarium")
	Terrarium idTerrarium;
	@Id
	@Column(name="time")
	Time time;
	@Column(name="temperature")
	double temperature;
	@Column(name="humidity")
	double humidity;
	public TerrariumData() {
		
	}
	public Terrarium getIdTerrarium() {
		return idTerrarium;
	}
	public void setIdTerrarium(Terrarium idTerrarium) {
		this.idTerrarium = idTerrarium;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
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
