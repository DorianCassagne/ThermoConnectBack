package me.dcal.thermoconnect.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
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

import me.dcal.thermoconnect.model.api.BodySpecies;
import me.dcal.thermoconnect.model.api.BodyTerrarium;


@Entity
@Table(name="terrarium", schema = "thermoconnect")
public class Terrarium {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="id_terrarium", unique=true)
    Integer idTerrarium;
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
	@Column(name="size_terrarium")
	String size;
	@Column(name="humidity_terrarium")
	double humidityTerrarium;
	



	@ManyToOne
	@JoinColumn(name = "username")
	User username; 
	@OneToMany( targetEntity=Animal.class, mappedBy="idTerrarium" )
	private List<Animal> animals = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "terrariumDataId.idTerrarium")
	Set<TerrariumData> terrariumDatas;
	
	
	public BodyTerrarium toBody() {
		BodyTerrarium bt = new BodyTerrarium();
		bt.nameTerrarium=nameTerrarium;
		bt.size=size;
		bt.startLightTime=startLightTime;
		bt.stopLightTime=startLightTime;
		bt.temperatureMax=temperatureMax;
		bt.temperatureMin=temperatureMin;
		bt.idTerrarium=idTerrarium;
		bt.humidityTerrarium=humidityTerrarium;
		return bt;
	}
	
	
	
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

	public String getSize() {
		return size;
	}




	public void setSize(String size) {
		this.size = size;
	}



	public Terrarium() {
		
	}
	


}
