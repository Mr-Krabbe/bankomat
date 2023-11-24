package de.krabbesoft.bankomat.business;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class InputParser {

	public static record ParseResult(int euro, int cent) {}

	public static ParseResult parse(Locale locale, String value) throws ParseException {
		NumberFormat format = DecimalFormat.getInstance(locale);
		Number number = format.parse(value);
		double doubleValue = number.doubleValue();

		int euro = (int) doubleValue;
		int multiplied = (int) (doubleValue * 100);
		int cent = multiplied - euro * 100;

		return new ParseResult(euro, cent);
	}

}
