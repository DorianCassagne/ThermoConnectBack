package me.dcal.thermoconnect.id;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import me.dcal.thermoconnect.model.Terrarium;

@Embeddable
public class TerrariumDataId implements Serializable {
	

	@Column(name = "id_terrarium")
	Integer idTerrarium; 
	@Column(name="time")
	Timestamp time;

	public TerrariumDataId() {
	}
	public TerrariumDataId(Integer idTerrarium, Timestamp time) {
		this.idTerrarium = idTerrarium;
		this.time = time;
	}

	public Integer getIdTerrarium() {
		return idTerrarium;
	}

	public void setIdTerrarium(Integer idTerrarium) {
		this.idTerrarium = idTerrarium;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}






	

}
