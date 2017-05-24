package it.polito.tdp.bar.model;

public class TestStatistiche {

	public static void main(String[] args) {
		
		Statistiche s = new Statistiche();
    	int time = 0;
    	for(int i=0; i<2000; i++){
    		s.addGruppo(time+(int)((Math.random()+1)*10));
    	}
    	s.run();
    	System.out.println("Numero clienti totali "+s.getClientiTot());
    	System.out.println("\nNumero clienti soddisfatti: "+s.getClientiSoddisfatti());
    	System.out.println("Numero clienti insoddisfatti: "+s.getClientiInsoddisfatti());

	}

}
