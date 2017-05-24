package it.polito.tdp.bar.model;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import it.polito.tdp.bar.model.Event.EventType;

public class Statistiche {
	//Parametri di simulazione --> impostati all'inizio da chi fa simulazione
	private int MIN_NUM_PERS = 1;
	private int MAX_NUM_PERS = 10;
	private int MIN_DURATA = 60;
	private int MAX_DURATA = 2;
	
	//Stato del modello
	private Map<Integer, Tavolo> tavoli;
	//Variabili di interesse
	private int clientiTot = 0; //numero clienti arrivati al bar(serviti o meno)
	private int clientiInsoddisfatti = 0;
	private int clientiSoddisfatti = 0;
	//Lista degli eventi
	private PriorityQueue<Event> queue;
	
	public Statistiche(){
		queue = new PriorityQueue<>();
		tavoli = new HashMap<Integer,Tavolo>();
		Tavolo t;
		for(int i = 0; i<15; i++){
			if(i<2){
				t= new Tavolo(i+1,10, true);
			}else if(i<6){
				t = new Tavolo(i+1,8,true);
			}else if(i<10){
				t = new Tavolo(i+1,6,true);
			}else{
				t = new Tavolo(i+1,4,true);
			}
			tavoli.put(t.getIdTavolo(), t);
		}
	}
	public void addGruppo(int time){
		int num_pers = ((int)(Math.random()*MAX_NUM_PERS))+MIN_NUM_PERS;
		int durata = this.MIN_DURATA*(int)(1+Math.random()*this.MAX_DURATA);
		Gruppo g = new Gruppo(num_pers, durata, (float)Math.random());
		queue.add(new Event(time, g, EventType.ARRIVO_GRUPPO_CLIENTI));
	}
	public void run(){
		while(!queue.isEmpty()){
			Event e = queue.poll();
			switch(e.getTipo()){
			case ARRIVO_GRUPPO_CLIENTI:
				this.processArrivoGruppo(e);
				break;
			case USCITA_GRUPPO_CLIENTI:
				tavoli.get(e.getGruppo().getIdTavolo()).setLibero(true);
				System.out.println("Clienti usciti, tavolo libero "+tavoli.get(e.getGruppo().getIdTavolo()).getIdTavolo());
				break;
			}
			
		}
	}
	
	
	private void processArrivoGruppo(Event e){
		
		
		Gruppo g = e.getGruppo();
		Tavolo tMin = null;
		int diffMin = 1000;
		clientiTot+= g.getNumPersone();
		for(Tavolo t : tavoli.values()){
			int diff = t.getNumeroPosti()-g.getNumPersone();
			if(t.isLibero() && diff>0 && diff<= diffMin){
				diffMin = diff;
				tMin = t;
			}
		}
		if(tMin!=null && diffMin< tMin.getNumeroPosti()/2){
			//tavolo trovato: lo occupo, clienti soddisfatti, creo evento di uscita
			tavoli.get(tMin.getIdTavolo()).setLibero(false);;
			clientiSoddisfatti+= g.getNumPersone();
			//clientiTot+= g.getNumPersone();
			g.setIdTavolo(tMin.getIdTavolo());
			queue.add(new Event(e.getTime()+g.getDurata(),g,EventType.USCITA_GRUPPO_CLIENTI));
			System.out.println("Gruppo arrivato da "+g.getNumPersone()+" persone. Seduti al tavolo "+tMin.getIdTavolo());
						
		}else{
			//tavolo non trovato: vedo la tolleranza del gruppo e decido se metterli al bancone
			if(g.getTolleranza()==0){
				clientiInsoddisfatti+=g.getNumPersone();
				System.out.println("Gruppo arrivato da "+g.getNumPersone()+" persone. Insoddisfatti");
			}else{
				if(Math.random()<=g.getTolleranza()){
					//al bancone
					clientiSoddisfatti+= g.getNumPersone();
					System.out.println("Gruppo arrivato da "+g.getNumPersone()+" persone. Al bancone");
				}else{
					//insoddisfatti
					clientiInsoddisfatti+= g.getNumPersone();
					System.out.println("Gruppo arrivato da "+g.getNumPersone()+" persone. Insoddisfatti");
				}
			}
		}
		
		
		
	}
	/**
	 * @return the clientiTot
	 */
	public int getClientiTot() {
		return clientiTot;
	}
	/**
	 * @return the clientiInsoddisfatti
	 */
	public int getClientiInsoddisfatti() {
		return clientiInsoddisfatti;
	}
	/**
	 * @return the clientiSoddisfatti
	 */
	public int getClientiSoddisfatti() {
		return clientiSoddisfatti;
	}
	/**
	 * @param mIN_NUM_PERS the mIN_NUM_PERS to set
	 */
	public void setMIN_NUM_PERS(int mIN_NUM_PERS) {
		MIN_NUM_PERS = mIN_NUM_PERS;
	}
	/**
	 * @param mAX_NUM_PERS the mAX_NUM_PERS to set
	 */
	public void setMAX_NUM_PERS(int mAX_NUM_PERS) {
		MAX_NUM_PERS = mAX_NUM_PERS;
	}
	/**
	 * @param mIN_DURATA the mIN_DURATA to set
	 */
	public void setMIN_DURATA(int mIN_DURATA) {
		MIN_DURATA = mIN_DURATA;
	}
	/**
	 * @param mAX_DURATA the mAX_DURATA to set
	 */
	public void setMAX_DURATA(int mAX_DURATA) {
		MAX_DURATA = mAX_DURATA;
	}
	
	
	
	
}
