package com.inn;

import org.junit.Assert;
import org.junit.Test;

import com.inn.Calculator.NegativeNumberException;
import com.inn.Calculator.StringCalculator;

public class StringCalculatorTest {

	StringCalculator calculate = new StringCalculator();

	@Test
	public void getCalledCountTest() {
		try {
			calculate.add("");
			calculate.add("1,98");
			Assert.assertEquals(8, calculate.getCalledCount());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void addEmptyStringTest() {
		try {
			Assert.assertEquals(0, calculate.add(""));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void addOneNumberStringTest() {
		try {
			Assert.assertEquals(2, calculate.add("2"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void addTwoNumberStringTest() {
		try {
			Assert.assertEquals(2, calculate.add("1,1"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void addMoreThanTwoNumberStringTest() {
		try {
			Assert.assertEquals(11, calculate.add("1,1,4,5"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void addNumberStringWithNextLineCharacterTest() {
		try {
			Assert.assertEquals(7, calculate.add("1,1\n 5"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void addNumberStringWithDelimitersCharacterTest() {
		try {
			Assert.assertEquals(14, calculate.add("//;\\n12;2"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void addNumberStringWithNegativeNumberTest() {
		try {
			int sum = calculate.add("12;-2");
			Assert.fail();

		} catch (NegativeNumberException nx) {
			Assert.assertEquals("Negative Numbers not allowed: [-2]", nx.getMessage());
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void addNumberStringWithMultipleNegativeNumberTest() {
		try {
			int sum = calculate.add(",-19,-12,-2");

		} catch (NegativeNumberException nx) {
			Assert.assertEquals("Negative Numbers not allowed: [-19, -12, -2]", nx.getMessage());
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
