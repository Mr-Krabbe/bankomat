package de.krabbesoft.bankomat.resources.responses;

import de.krabbesoft.bankomat.model.Stueckelung;

public class StueckelungResponse {

	private int num200EuroSchein;
	private int num100EuroSchein;
	private int num50EuroSchein;
	private int num20EuroSchein;
	private int num10EuroSchein;
	private int num5EuroSchein;
	private int num2EuroMuenze;
	private int num1EuroMuenze;
	private int num50CentMuenze;
	private int num20CentMuenze;
	private int num10CentMuenze;
	private int num5CentMuenze;
	private int num2CentMuenze;
	private int num1CentMuenze;

	private StueckelungResponse() {
		// Use static factory method 'of' instead
	}
	
	public static StueckelungResponse of(Stueckelung stueckelung) {
		StueckelungResponse response = new StueckelungResponse();
		response.num200EuroSchein = stueckelung.num200EuroSchein();
		response.num100EuroSchein = stueckelung.num100EuroSchein();
		response.num50EuroSchein = stueckelung.num50EuroSchein();
		response.num20EuroSchein = stueckelung.num20EuroSchein();
		response.num10EuroSchein = stueckelung.num10EuroSchein();
		response.num5EuroSchein = stueckelung.num5EuroSchein();
		response.num2EuroMuenze = stueckelung.num2EuroMuenze();
		response.num1EuroMuenze = stueckelung.num1EuroMuenze();
		response.num50CentMuenze = stueckelung.num50CentMuenze();
		response.num20CentMuenze = stueckelung.num20CentMuenze();
		response.num10CentMuenze = stueckelung.num10CentMuenze();
		response.num5CentMuenze = stueckelung.num5CentMuenze();
		response.num2CentMuenze = stueckelung.num2CentMuenze();
		response.num1CentMuenze = stueckelung.num1CentMuenze();
		
		return response;
	}

	public int getNum200EuroSchein() {
		return num200EuroSchein;
	}

	public int getNum100EuroSchein() {
		return num100EuroSchein;
	}

	public int getNum50EuroSchein() {
		return num50EuroSchein;
	}

	public int getNum20EuroSchein() {
		return num20EuroSchein;
	}

	public int getNum10EuroSchein() {
		return num10EuroSchein;
	}

	public int getNum5EuroSchein() {
		return num5EuroSchein;
	}

	public int getNum2EuroMuenze() {
		return num2EuroMuenze;
	}

	public int getNum1EuroMuenze() {
		return num1EuroMuenze;
	}

	public int getNum50CentMuenze() {
		return num50CentMuenze;
	}

	public int getNum20CentMuenze() {
		return num20CentMuenze;
	}

	public int getNum10CentMuenze() {
		return num10CentMuenze;
	}

	public int getNum5CentMuenze() {
		return num5CentMuenze;
	}

	public int getNum2CentMuenze() {
		return num2CentMuenze;
	}

	public int getNum1CentMuenze() {
		return num1CentMuenze;
	}
	
}
