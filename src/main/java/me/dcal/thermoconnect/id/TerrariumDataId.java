package me.dcal.thermoconnect.id;

import java.io.Serializable;
import java.sql.Time;



import me.dcal.thermoconnect.model.Terrarium;

public class TerrariumDataId implements Serializable {
	
	Terrarium idTerrarium;
	
	Time time;

	public TerrariumDataId(Terrarium idTerrarium, Time time) {
		super();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTerrarium == null) ? 0 : idTerrarium.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TerrariumDataId other = (TerrariumDataId) obj;
		if (idTerrarium == null) {
			if (other.idTerrarium != null)
				return false;
		} else if (!idTerrarium.equals(other.idTerrarium))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	





	

}
