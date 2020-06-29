package it.polito.tdp.crimes.model;

public class Vicino implements Comparable<Vicino> {
	
	Integer distretto;
	Double distanza;
	
	public Vicino(Integer distretto, Double distanza) {
		super();
		this.distretto = distretto;
		this.distanza = distanza;
	}

	public Integer getDistretto() {
		return distretto;
	}

	public void setDistretto(Integer distretto) {
		this.distretto = distretto;
	}

	public Double getDistanza() {
		return distanza;
	}

	public void setDistanza(Double distanza) {
		this.distanza = distanza;
	}

	@Override
	public int compareTo(Vicino o) {
		// TODO Auto-generated method stub
		return this.distanza.compareTo(o.getDistanza());
	}
	

}
