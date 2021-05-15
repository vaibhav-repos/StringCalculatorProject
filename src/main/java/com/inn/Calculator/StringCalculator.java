package com.inn.Calculator;

public class StringCalculator {
	
	public int add(String numbers) {
		if(numbers.length() == 0)
			return 0;
		else if(numbers.length() == 1)
			return Integer.parseInt(numbers);
		else {
			if(numbers.contains(",\n"))
				return -1;
			String arr[] = numbers.split(",|\n");
			int sum = 0;
			for(String number: arr)
			{
				String s = number.strip();
				sum += Integer.parseInt(s);
			}
			return sum;
		}
	}

}
