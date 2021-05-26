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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_terrarium", unique=true)
	Integer idTerrarium;
	@Column(name="temperature_min")
	Double temperatureMin;
	@Column(name="temperature_max")
	Double temperatureMax;
	@Column(name="name_terrarium")
	String nameTerrarium;
	@Column(name="start_light_time")
	Time startLightTime;
	@Column(name="stop_light_time")
	Time stopLightTime;
	@Column(name="size_terrarium")
	String sizeTerrarium;
	@Column(name="humidity_terrarium")
	private
	Double humidityTerrarium;

	@ManyToOne
	@JoinColumn(name = "username")
	User username; 
	@OneToMany(cascade = CascadeType.ALL, targetEntity=Animal.class, mappedBy="idTerrarium" )
	List<Animal> animals = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "terrariumDataId.idTerrarium")
	List<TerrariumData> terrariumDatas = new ArrayList<>();;


//	public Terrarium(BodyTerrarium bt) {
//		this.setUsername(userRepository.getOne(username));
//		t.setStartLightTime(startTime);
//		t.setStopLightTime(stopTime);
//		t.setTemperatureMax(temperatureMax);
//		t.setTemperatureMin(temperatureMin);
//		t.setSize(sizeTerrarium);
//		terrariumRepository.save(t);
//	}
//	public Terrarium() {
//
//	}
//
//
//	public BodyTerrarium toBody() {
//		BodyTerrarium bt = new BodyTerrarium();
//		bt.nameTerrarium=nameTerrarium;
//		bt.size=size;
//		bt.startLightTime=startLightTime;
//		bt.stopLightTime=startLightTime;
//		bt.temperatureMax=temperatureMax;
//		bt.temperatureMin=temperatureMin;
//		bt.idTerrarium=idTerrarium;
//		bt.humidityTerrarium=humidityTerrarium;
//		return bt;
//	}



	public Integer getIdTerrarium() {
		return idTerrarium;
	}




	public void setIdTerrarium(Integer idTerrarium) {
		this.idTerrarium = idTerrarium;
	}




	public Double getTemperatureMin() {
		return temperatureMin;
	}




	public void setTemperatureMin(Double temperatureMin) {
		this.temperatureMin = temperatureMin;
	}




	public Double getTemperatureMax() {
		return temperatureMax;
	}




	public void setTemperatureMax(Double temperatureMax) {
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

	public String getSizeTerrarium() {
		return sizeTerrarium;
	}




	public void setSizeTerrarium(String size) {
		this.sizeTerrarium = size;
	}




	public Double getHumidityTerrarium() {
		return humidityTerrarium;
	}




	public void setHumidityTerrarium(Double humidityTerrarium) {
		this.humidityTerrarium = humidityTerrarium;
	}






}
