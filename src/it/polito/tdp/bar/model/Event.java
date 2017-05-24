package it.polito.tdp.bar.model;

public class Event implements Comparable<Event> {
	
	public enum EventType{
		ARRIVO_GRUPPO_CLIENTI, USCITA_GRUPPO_CLIENTI
	}
	private int time;
	private Gruppo gruppo;
	private EventType tipo;
	

	public Event(int time, Gruppo gruppo, EventType tipo) {
		super();
		this.time = time;
		this.gruppo = gruppo;
		this.tipo = tipo;
	}


	@Override
	public int compareTo(Event other) {
		return this.time-other.time;
	}


	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}


	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}


	/**
	 * @return the gruppo
	 */
	public Gruppo getGruppo() {
		return gruppo;
	}


	/**
	 * @param gruppo the gruppo to set
	 */
	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}


	/**
	 * @return the tipo
	 */
	public EventType getTipo() {
		return tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(EventType tipo) {
		this.tipo = tipo;
	}

	
}
