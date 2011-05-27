package objective.training;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	Calculator calculator = new CalculatorTabajara();
	
	@Test
	public void testSimpleAdd() {
		Assert.assertEquals("3", calculator.add("1", "2"));
	}
	
	@Test
	public void testBoundaryLongAdd() {
		Assert.assertEquals("9223372036854775808", calculator.add("9223372036854775807", "1"));
	}
	
	@Test
	public void testBoundaryAdd() {
		Assert.assertEquals("18446744073709551614", calculator.add("9223372036854775807", "9223372036854775807"));
	}
	
	@Test
	public void testSimpleSubtract() {
		Assert.assertEquals("2", calculator.subract("3", "1"));
	}
	
	@Test
	public void testMoreDigitsSubtract() {
		Assert.assertEquals("31", calculator.subract("32", "1"));
	}
	
	@Test
	public void testOverflowSubtract() {
		Assert.assertEquals("9", calculator.subract("32", "23"));
	}
	
	@Test
	public void testZerosSubtract() {
		Assert.assertEquals("0", calculator.subract("9", "9"));
	}
	
	@Test
	public void testZerosMoreDigitsSubtract() {
		Assert.assertEquals("0", calculator.subract("120", "120"));
	}
	
	@Test
	public void testCompareRightBiggerThanLeft() {
		Assert.assertEquals(+1, calculator.compare("9", "10"));
	}
	
	@Test
	public void testCompareRightBiggerThanLeftSameDigits() {
		Assert.assertEquals(+1, calculator.compare("10", "12"));
	}
	
	@Test
	public void testCompareLeftBiggerThanRight() {
		Assert.assertEquals(-1, calculator.compare("10", "9"));
	}
	
	@Test
	public void testCompareEquals() {
		Assert.assertEquals(0, calculator.compare("9", "9"));
	}
	
}
