package de.krabbesoft.bankomat.model;

public record Stueckelung(
		int num200EuroSchein, int num100EuroSchein, int num50EuroSchein, int num20EuroSchein,
		int num10EuroSchein, int num5EuroSchein, int num2EuroMuenze, int num1EuroMuenze, int num50CentMuenze,
		int num20CentMuenze, int num10CentMuenze, int num5CentMuenze, int num2CentMuenze, int num1CentMuenze) {

	public static Stueckelung of(int[] values) {
		if (values.length != 14) {
			throw new IllegalArgumentException("the passed values array must have exactly 14 values");
		}
		
		return new Stueckelung(
				values[0], 
				values[1],
				values[2],
				values[3],
				values[4],
				values[5],
				values[6],
				values[7],
				values[8],
				values[9],
				values[10],
				values[11],
				values[12],
				values[13]);
	}
	
}
