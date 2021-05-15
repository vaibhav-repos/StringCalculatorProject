package com.inn.Calculator;

public class StringCalculator {
	
	public int add(String numbers) {
		if(numbers.length() == 0)
			return 0;
		else if(numbers.length() == 1)
			return Integer.parseInt(numbers);
		else {
			String arr[] = numbers.split(",");
			int sum = 0;
			for(String number: arr)
			{
				sum += Integer.parseInt(number);
			}
			return sum;
		}
	}

}
