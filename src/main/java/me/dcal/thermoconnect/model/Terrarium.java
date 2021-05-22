package me.dcal.thermoconnect.model;

import java.sql.Time;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="terrarium", schema = "thermoconnect")
public class Terrarium {
//	@GeneratedValue(strategy = GenerationType.AUTO)

	@Id
	@Column(name="id_terrarium", unique=true)
    Integer idTerrarium;
//	@Column(name="idTerrarium", unique=true)
//	long idTerrarium;
	@Column(name="temperature_min")
	double temperatureMin;
	@Column(name="temperature_max")
	double temperatureMax;
	@Column(name="name_terrarium")
	String nameTerrarium;
	@Column(name="start_light_time")
	Time startLightTime;
	@Column(name="stop_light_time")
	Time stopLightTime;
	@ManyToOne
	@JoinColumn(name = "username")
	User username; 
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "idTerrarium")
//	Set<TerrariumData> mesdatas;
	
	
	
	
	public int getIdTerrarium() {
		return idTerrarium;
	}




	public void setIdTerrarium(int idTerrarium) {
		this.idTerrarium = idTerrarium;
	}




	public double getTemperatureMin() {
		return temperatureMin;
	}




	public void setTemperatureMin(double temperatureMin) {
		this.temperatureMin = temperatureMin;
	}




	public double getTemperatureMax() {
		return temperatureMax;
	}




	public void setTemperatureMax(double temperatureMax) {
		this.temperatureMax = temperatureMax;
	}




	public String getNameTerrarium() {
		return nameTerrarium;
	}




	public void setNameTerrarium(String nameTerrarium) {
		this.nameTerrarium = nameTerrarium;
	}




	public Time getStartLightTime() {
		return startLightTime;
	}




	public void setStartLightTime(Time startLightTime) {
		this.startLightTime = startLightTime;
	}




	public Time getStopLightTime() {
		return stopLightTime;
	}




	public void setStopLightTime(Time stopLightTime) {
		this.stopLightTime = stopLightTime;
	}




	public User getUsername() {
		return username;
	}




	public void setUsername(User username) {
		this.username = username;
	}




	public Terrarium() {
		
	}
	


}
