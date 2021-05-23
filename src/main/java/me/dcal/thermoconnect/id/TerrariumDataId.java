package me.dcal.thermoconnect.id;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import me.dcal.thermoconnect.model.Terrarium;

@Embeddable
public class TerrariumDataId implements Serializable {
	
	@ManyToOne
	@JoinColumn(name = "id_terrarium")
	Terrarium idTerrarium; 
	@Column(name="time")
	Time time;

	public TerrariumDataId() {
	}
	public TerrariumDataId(Terrarium idTerrarium, Time time) {
		this.idTerrarium = idTerrarium;
		this.time = time;
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






	

}
