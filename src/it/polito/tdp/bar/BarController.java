/**
 * Sample Skeleton for 'Bar.fxml' Controller Class
 */

package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.bar.model.Statistiche;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BarController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doSimulazione(ActionEvent event) {
    	Statistiche s = new Statistiche();
    	int time = 0;
    	for(int i=0; i<2000; i++){
    		s.addGruppo(time+(int)((Math.random()+1)*10));
    	}
    	s.run();
    	txtResult.setText("Numero clienti totali "+s.getClientiTot());
    	txtResult.appendText("\nNumero clienti soddisfatti: "+s.getClientiSoddisfatti());
    	txtResult.appendText("\nNumero clienti insoddisfatti: "+s.getClientiInsoddisfatti());

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Bar.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";

    }
}
