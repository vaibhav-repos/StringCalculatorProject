package com.inn;

import org.junit.Assert;
import org.junit.Test;

import com.inn.Calculator.StringCalculator;

public class StringCalculatorTest {
	
	StringCalculator calculate = new StringCalculator();
	
	@Test
	public void addTest() {
		Assert.assertEquals(2,calculate.add("1,1"));
	}

}
