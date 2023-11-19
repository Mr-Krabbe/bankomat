package de.krabbesoft.bankomat.business;

import de.krabbesoft.bankomat.model.Stueckelung;

public interface Bankomat {
	
	/**
	 * Berechnet eine Stückelung, in die der <code>wert</code> zerlegt werden kann. Die tatsächliche
	 * Stückelung hängt von der konkreten Implementierung ab.
	 * 
	 * @param wert Der Wert, der gestückelt werden soll
	 * @return Eine Stückelung für den <code>wert</code>
	 */
	Stueckelung berechneStueckelung(double wert);

}
