package it.polito.tdp.crimes.model;

public class Distretto {
	
	Integer numDistretto;
	Double lon;
	Double lat;
	
	public Distretto(Integer numDistretto, Double lon, Double lat) {
		super();
		this.numDistretto = numDistretto;
		this.lon = lon;
		this.lat = lat;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numDistretto == null) ? 0 : numDistretto.hashCode());
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
		Distretto other = (Distretto) obj;
		if (numDistretto == null) {
			if (other.numDistretto != null)
				return false;
		} else if (!numDistretto.equals(other.numDistretto))
			return false;
		return true;
	}

	public Integer getNumDistretto() {
		return numDistretto;
	}

	public void setNumDistretto(Integer numDistretto) {
		this.numDistretto = numDistretto;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

}
