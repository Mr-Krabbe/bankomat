package bankomat;

import java.text.ParseException;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.krabbesoft.bankomat.business.InputParser;
import de.krabbesoft.bankomat.business.InputParser.ParseResult;

public class InputParserTest {
	
	@Test
	public void standardTest_000() throws ParseException {
		ParseResult parseResult = InputParser.parse(Locale.GERMANY, "0");
		
		Assertions.assertEquals(0, parseResult.euro());
		Assertions.assertEquals(0, parseResult.cent());
	}
	
	@Test
	public void standardTest_001() throws ParseException {
		ParseResult parseResult = InputParser.parse(Locale.GERMANY, "120");
		
		Assertions.assertEquals(120, parseResult.euro());
		Assertions.assertEquals(0, parseResult.cent());
	}
	
	@Test
	public void standardTest_002() throws ParseException {
		ParseResult parseResult = InputParser.parse(Locale.GERMANY, "120,00");
		
		Assertions.assertEquals(120, parseResult.euro());
		Assertions.assertEquals(0, parseResult.cent());
	}
	
	@Test
	public void standardTest_003() throws ParseException {
		ParseResult parseResult = InputParser.parse(Locale.GERMANY, "120,0000");
		
		Assertions.assertEquals(120, parseResult.euro());
		Assertions.assertEquals(0, parseResult.cent());
	}
	
	@Test
	public void standardTest_004() throws ParseException {
		ParseResult parseResult = InputParser.parse(Locale.GERMANY, "120,009999");
		
		Assertions.assertEquals(120, parseResult.euro());
		Assertions.assertEquals(0, parseResult.cent());
	}
	
	@Test
	public void standardTest_005() throws ParseException {
		ParseResult parseResult = InputParser.parse(Locale.GERMANY, "120,50");
		
		Assertions.assertEquals(120, parseResult.euro());
		Assertions.assertEquals(50, parseResult.cent());
	}
	
	
	@Test
	public void standardTest_006() throws ParseException {
		ParseResult parseResult = InputParser.parse(Locale.GERMANY, "120,5099");
		
		Assertions.assertEquals(120, parseResult.euro());
		Assertions.assertEquals(50, parseResult.cent());
	}
	
	@Test
	public void standardTest_007() throws ParseException {
		ParseResult parseResult = InputParser.parse(Locale.GERMANY, "234,23");
		
		Assertions.assertEquals(234, parseResult.euro());
		Assertions.assertEquals(23, parseResult.cent());
	}
	
	@Test
	public void localeTest_004() throws ParseException {
		ParseResult parseResult = InputParser.parse(Locale.GERMANY, "234.23");
		
		Assertions.assertEquals(23423, parseResult.euro());
		Assertions.assertEquals(0, parseResult.cent());
	}
	
	@Test
	public void localeTest_005() throws ParseException {
		ParseResult parseResult = InputParser.parse(Locale.UK, "234.23");
		
		Assertions.assertEquals(234, parseResult.euro());
		Assertions.assertEquals(23, parseResult.cent());
	}
	
	@Test
	public void invalidInputTest_000() throws ParseException {
		Assertions.assertThrows(ParseException.class, () -> {
			ParseResult parseResult = InputParser.parse(Locale.GERMANY, "Das ist keine Zahl");
			
			Assertions.assertEquals(234, parseResult.euro());
			Assertions.assertEquals(23, parseResult.cent());		
		});
	}
	
	@Test
	public void mixedInputTest_000() throws ParseException {
		ParseResult parseResult = InputParser.parse(Locale.GERMANY, "12,23 Das hier können wir parsen");
		
		Assertions.assertEquals(12, parseResult.euro());
		Assertions.assertEquals(23, parseResult.cent());
	}
	
	@Test
	public void negativeInputTest_000() throws ParseException {
		ParseResult parseResult = InputParser.parse(Locale.GERMANY, "-167");
		
		Assertions.assertEquals(-167, parseResult.euro());
		Assertions.assertEquals(0, parseResult.cent());
	}

}
