package de.krabbesoft.bankomat.business;

import de.krabbesoft.bankomat.model.Stueckelung;

public interface Bankomat {
	
	/**
	 * Berechnet eine Stückelung, in die der gegebene Betrag zerlegt werden kann. Die tatsächliche
	 * Stückelung hängt von der konkreten Implementierung ab.
	 * 
	 * @param euro Der ganze Euro Betrag
	 * @param cents Die Cents des Betrages
	 * @return Eine Stückelung für den Gesamtbetrag
	 */
	Stueckelung berechneStueckelung(int euro, int cents);

}
