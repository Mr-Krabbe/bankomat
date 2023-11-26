package de.krabbesoft.bankomat.business;

import java.math.BigDecimal;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class InputParser {

	public static record ParseResult(int euro, int cent) {}

	public static ParseResult parse(Locale locale, String value) throws NumberFormatException {
		char decimalSeparator = DecimalFormatSymbols.getInstance(locale).getDecimalSeparator();
		
		value = value.replace(decimalSeparator, '.');
		BigDecimal gesamt = new BigDecimal(value);

		int euro = gesamt.intValue();
		int cent = gesamt.remainder(BigDecimal.ONE).multiply(BigDecimal.valueOf(100)).intValue();

		return new ParseResult(euro, cent);
	}

}
