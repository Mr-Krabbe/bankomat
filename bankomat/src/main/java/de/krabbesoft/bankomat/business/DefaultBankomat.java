package de.krabbesoft.bankomat.business;

import de.krabbesoft.bankomat.model.Stueckelung;

/**
 * Der <code>DefaultBankomat</code> berechnet die Stückelung für einen Wert in der Weise, dass
 * immer die größtmöglichen Scheine bzw. Münzen zuerst genommen werden. Damit wird erreicht, dass 
 * möglichst wenige Scheine und Münzen benötigt werden.
 * 
 * @author Christoph
 */
public class DefaultBankomat implements Bankomat {

	private final double[] betraege = { 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01 };
	private final int[] betragAnzahlen = new int[betraege.length];

	@Override
	public Stueckelung berechneStueckelung(double wert) throws IllegalArgumentException {
		if (wert < 0) {
			throw new IllegalArgumentException("values less than 0 are not allowed");
		}
		
		int betragIndex = 0;
		double restWert = wert;

		while (betragIndex < betraege.length) {
			double aktuellerBetrag = betraege[betragIndex];
			int passtNMal = (int) (restWert / aktuellerBetrag);
			if (passtNMal > 0) {
				betragAnzahlen[betragIndex] = passtNMal;
				restWert = restWert - (aktuellerBetrag * passtNMal);
			}
			
			betragIndex++;
		}
		
		return Stueckelung.of(betragAnzahlen);
	}

}
