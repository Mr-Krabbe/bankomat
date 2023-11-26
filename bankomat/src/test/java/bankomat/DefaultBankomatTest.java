package bankomat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.krabbesoft.bankomat.business.DefaultBankomat;
import de.krabbesoft.bankomat.model.Stueckelung;

public class DefaultBankomatTest {

	private final DefaultBankomat bankomat = new DefaultBankomat();
	
	@Test
	public void test_000() {
		Stueckelung stueckelung = bankomat.berechneStueckelung(234, 23);
		Assertions.assertEquals(1, stueckelung.num200EuroSchein());
		Assertions.assertEquals(0, stueckelung.num100EuroSchein());
		Assertions.assertEquals(0, stueckelung.num50EuroSchein());
		Assertions.assertEquals(1, stueckelung.num20EuroSchein());
		Assertions.assertEquals(1, stueckelung.num10EuroSchein());
		Assertions.assertEquals(2, stueckelung.num2EuroMuenze());
		Assertions.assertEquals(0, stueckelung.num1EuroMuenze());
		Assertions.assertEquals(0, stueckelung.num50CentMuenze());
		Assertions.assertEquals(1, stueckelung.num20CentMuenze());
		Assertions.assertEquals(0, stueckelung.num10CentMuenze());
		Assertions.assertEquals(0, stueckelung.num5CentMuenze());
		Assertions.assertEquals(1, stueckelung.num2CentMuenze());
		Assertions.assertEquals(1, stueckelung.num1CentMuenze());
	}
	
	@Test
	public void test_001() {
		Stueckelung stueckelung = bankomat.berechneStueckelung(451, 86);
		Assertions.assertEquals(2, stueckelung.num200EuroSchein());
		Assertions.assertEquals(0, stueckelung.num100EuroSchein());
		Assertions.assertEquals(1, stueckelung.num50EuroSchein());
		Assertions.assertEquals(0, stueckelung.num20EuroSchein());
		Assertions.assertEquals(0, stueckelung.num10EuroSchein());
		Assertions.assertEquals(0, stueckelung.num2EuroMuenze());
		Assertions.assertEquals(1, stueckelung.num1EuroMuenze());
		Assertions.assertEquals(1, stueckelung.num50CentMuenze());
		Assertions.assertEquals(1, stueckelung.num20CentMuenze());
		Assertions.assertEquals(1, stueckelung.num10CentMuenze());
		Assertions.assertEquals(1, stueckelung.num5CentMuenze());
		Assertions.assertEquals(0, stueckelung.num2CentMuenze());
		Assertions.assertEquals(1, stueckelung.num1CentMuenze());
	}
	
	@Test
	public void test_002() {
		Stueckelung stueckelung = bankomat.berechneStueckelung(0, 01);
		Assertions.assertEquals(0, stueckelung.num200EuroSchein());
		Assertions.assertEquals(0, stueckelung.num100EuroSchein());
		Assertions.assertEquals(0, stueckelung.num50EuroSchein());
		Assertions.assertEquals(0, stueckelung.num20EuroSchein());
		Assertions.assertEquals(0, stueckelung.num10EuroSchein());
		Assertions.assertEquals(0, stueckelung.num2EuroMuenze());
		Assertions.assertEquals(0, stueckelung.num1EuroMuenze());
		Assertions.assertEquals(0, stueckelung.num50CentMuenze());
		Assertions.assertEquals(0, stueckelung.num20CentMuenze());
		Assertions.assertEquals(0, stueckelung.num10CentMuenze());
		Assertions.assertEquals(0, stueckelung.num5CentMuenze());
		Assertions.assertEquals(0, stueckelung.num2CentMuenze());
		Assertions.assertEquals(1, stueckelung.num1CentMuenze());
	}
	
	@Test
	void test_003() {
		Stueckelung stueckelung = bankomat.berechneStueckelung(0, 0);
		Assertions.assertEquals(0, stueckelung.num200EuroSchein());
		Assertions.assertEquals(0, stueckelung.num100EuroSchein());
		Assertions.assertEquals(0, stueckelung.num50EuroSchein());
		Assertions.assertEquals(0, stueckelung.num20EuroSchein());
		Assertions.assertEquals(0, stueckelung.num10EuroSchein());
		Assertions.assertEquals(0, stueckelung.num2EuroMuenze());
		Assertions.assertEquals(0, stueckelung.num1EuroMuenze());
		Assertions.assertEquals(0, stueckelung.num50CentMuenze());
		Assertions.assertEquals(0, stueckelung.num20CentMuenze());
		Assertions.assertEquals(0, stueckelung.num10CentMuenze());
		Assertions.assertEquals(0, stueckelung.num5CentMuenze());
		Assertions.assertEquals(0, stueckelung.num2CentMuenze());
		Assertions.assertEquals(0, stueckelung.num1CentMuenze());
	}
	
	@Test
	void test_004() {
		Assertions.assertThrows(
				IllegalArgumentException.class, 
				() -> bankomat.berechneStueckelung(-500, 0), 
				"expected IllegalArgumentException to be thrown for negative values");
	}
	
	@Test
	void test_005() {
		Stueckelung stueckelung = bankomat.berechneStueckelung(200780, 13);
		Assertions.assertEquals(1003, stueckelung.num200EuroSchein());
		Assertions.assertEquals(1, stueckelung.num100EuroSchein());
		Assertions.assertEquals(1, stueckelung.num50EuroSchein());
		Assertions.assertEquals(1, stueckelung.num20EuroSchein());
		Assertions.assertEquals(1, stueckelung.num10EuroSchein());
		Assertions.assertEquals(0, stueckelung.num2EuroMuenze());
		Assertions.assertEquals(0, stueckelung.num1EuroMuenze());
		Assertions.assertEquals(0, stueckelung.num50CentMuenze());
		Assertions.assertEquals(0, stueckelung.num20CentMuenze());
		Assertions.assertEquals(1, stueckelung.num10CentMuenze());
		Assertions.assertEquals(0, stueckelung.num5CentMuenze());
		Assertions.assertEquals(1, stueckelung.num2CentMuenze());
		Assertions.assertEquals(1, stueckelung.num1CentMuenze());
	}
	
	@Test
	void test_006() {
		Stueckelung stueckelung = bankomat.berechneStueckelung(150, 23);
		Assertions.assertEquals(1, stueckelung.num20CentMuenze());
		Assertions.assertEquals(1, stueckelung.num2CentMuenze());
		Assertions.assertEquals(1, stueckelung.num1CentMuenze());
	}

}
