package it.polito.tdp.bar.model;

public class Gruppo {

	private int numPersone;
	private int durata;
	private float tolleranza;
	private int idTavolo;
	
	public Gruppo(int numPersone, int durata, float tolleranza) {
		super();
		this.numPersone = numPersone;
		this.durata = durata;
		this.tolleranza = tolleranza;
		this.idTavolo = 0;
	}

	
	/**
	 * @return the idTavolo
	 */
	public int getIdTavolo() {
		return idTavolo;
	}


	/**
	 * @param idTavolo the idTavolo to set
	 */
	public void setIdTavolo(int idTavolo) {
		this.idTavolo = idTavolo;
	}


	/**
	 * @return the numPersone
	 */
	public int getNumPersone() {
		return numPersone;
	}

	/**
	 * @param numPersone the numPersone to set
	 */
	public void setNumPersone(int numPersone) {
		this.numPersone = numPersone;
	}

	/**
	 * @return the durata
	 */
	public int getDurata() {
		return durata;
	}

	/**
	 * @param durata the durata to set
	 */
	public void setDurata(int durata) {
		this.durata = durata;
	}

	/**
	 * @return the tolleranza
	 */
	public float getTolleranza() {
		return tolleranza;
	}

	/**
	 * @param tolleranza the tolleranza to set
	 */
	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}
	
	
}
