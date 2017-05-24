package it.polito.tdp.bar.model;

public class Tavolo {
	private int idTavolo;
	private int numeroPosti;
	private boolean libero;
	public Tavolo(int idTavolo,int numeroPosti, boolean libero) {
		super();
		this.idTavolo = idTavolo;
		this.numeroPosti = numeroPosti;
		this.libero = libero;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTavolo;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tavolo other = (Tavolo) obj;
		if (idTavolo != other.idTavolo)
			return false;
		return true;
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
	 * @return the numeroPosti
	 */
	public int getNumeroPosti() {
		return numeroPosti;
	}
	/**
	 * @param numeroPosti the numeroPosti to set
	 */
	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}
	/**
	 * @return the libero
	 */
	public boolean isLibero() {
		return libero;
	}
	/**
	 * @param libero the libero to set
	 */
	public void setLibero(boolean libero) {
		this.libero = libero;
	}
	
	

}
