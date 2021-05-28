package me.dcal.thermoconnect.id;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TerrariumDataId implements Serializable {
	

	
	private static final long serialVersionUID = 1L;
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
