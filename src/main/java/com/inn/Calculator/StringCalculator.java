package com.inn.Calculator;

public class StringCalculator {

	public String addNumbers(String nums) {
		String ans = "";
		int st = 0;
		int end = 0;
		for (int i = 0; i < nums.length(); i++) {
			if ((int) nums.charAt(i) >= 48 && (int) nums.charAt(i) <= 57) {
				if (end - st != 0)
					end++;
				else {
					st = i;
					end = i + 1;
				}
			} else {
				if (st - end != 0) {
					ans += nums.substring(st, end) + ",";
					st = 0;
					end = 0;
				}
			}
		}
		if (st - end != 0) 
			ans += nums.substring(st, end);
		return ans;
	}

	public int add(String numbers) {
		int sum = 0;
		if (numbers.length() == 0)
			return 0;
		else if (numbers.length() == 1)
			return Integer.parseInt(numbers);
		else {
			String addNumbers = addNumbers(numbers);
			String arr[] = addNumbers.split(",");
			for (String number : arr) {
				sum += Integer.parseInt(number);
				}
			}
		return sum;
		}
	}
