package com.inn;

import org.junit.Assert;
import org.junit.Test;

import com.inn.Calculator.NegativeNumberException;
import com.inn.Calculator.StringCalculator;

public class StringCalculatorTest {
	
	StringCalculator calculate = new StringCalculator();
	
	@Test
	public void addEmptyStringTest() {
		try {
			Assert.assertEquals(0,calculate.add(""));
		} catch (NegativeNumberException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void addOneNumberStringTest() {
		try {
			Assert.assertEquals(2,calculate.add("2"));
		} catch (NegativeNumberException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void addTwoNumberStringTest() {
		try {
			Assert.assertEquals(2,calculate.add("1,1"));
		} catch (NegativeNumberException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void addMoreThanTwoNumberStringTest() {
		try {
			Assert.assertEquals(11,calculate.add("1,1,4,5"));
		} catch (NegativeNumberException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void addNumberStringWithNextLineCharacterTest() {
		try {
			Assert.assertEquals(7,calculate.add("1,1\n 5"));
		} catch (NegativeNumberException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void addNumberStringWithDelimitersCharacterTest() {
		try {
			Assert.assertEquals(14,calculate.add("//;\\n12;2"));
		} catch (NegativeNumberException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void addNumberStringWithNegativeNumberTest() {
		try {
			int sum = calculate.add("12;-2");
			Assert.fail();
			
		}catch(NegativeNumberException nx) {
			Assert.assertEquals("Negative numbers not allowed!", nx.getMessage());
		}
	}

}
