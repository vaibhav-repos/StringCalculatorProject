package com.inn;

import org.junit.Assert;
import org.junit.Test;

import com.inn.Calculator.StringCalculator;

public class StringCalculatorTest {
	
	StringCalculator calculate = new StringCalculator();
	
	@Test
	public void addEmptyStringTest() {
		Assert.assertEquals(0,calculate.add(""));
	}
	
	@Test
	public void addOneNumberStringTest() {
		Assert.assertEquals(2,calculate.add("2"));
	}
	
	@Test
	public void addTwoNumberStringTest() {
		Assert.assertEquals(2,calculate.add("1,1"));
	}
	
	@Test
	public void addMoreThanTwoNumberStringTest() {
		Assert.assertEquals(11,calculate.add("1,1,4,5"));
	}
	
	@Test
	public void addNumberStringWithNextLineCharacterTest() {
		Assert.assertEquals(7,calculate.add("1,1\n 5"));
	}

}
