package de.krabbesoft.bankomat.business;

import de.krabbesoft.bankomat.model.Stueckelung;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Default;

/**
 * Der <code>DefaultBankomat</code> berechnet die Stückelung für einen Wert in der Weise, dass
 * immer die größtmöglichen Scheine bzw. Münzen zuerst genommen werden. Damit wird erreicht, dass 
 * möglichst wenige Scheine und Münzen benötigt werden.
 * 
 * @author Christoph
 */
@RequestScoped
@Default
public class DefaultBankomat implements Bankomat {

	private final int[] betraege = { 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1 };
	
	@Override
	public Stueckelung berechneStueckelung(int euro, int cents) throws IllegalArgumentException {
		if (euro < 0 || cents < 0) {
			throw new IllegalArgumentException("values less than 0 are not allowed");
		}
		
		int betragIndex = 0;
		int restWert = euro * 100 + cents; // entire calculation will be based on cents
		int[] betragAnzahlen = new int[betraege.length];

		while (betragIndex < betraege.length) {
			int aktuellerBetrag = betraege[betragIndex];
			int passtNMal = (int) (restWert / aktuellerBetrag);
			if (passtNMal > 0) {
				betragAnzahlen[betragIndex] = passtNMal;
				restWert = restWert % aktuellerBetrag;
			}
			
			betragIndex++;
		}
		
		return Stueckelung.of(betragAnzahlen);
	}

}
