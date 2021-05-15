package com.inn.Calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	public static int countAddCalls = 0;

	public String addNumbers(String nums) {
		String ans = "";
		int st = 0;
		int end = 0;
		for (int i = 0; i < nums.length(); i++) {
			if (((int) nums.charAt(i) >= 48 && (int) nums.charAt(i) <= 57)) {
				if (end - st != 0)
					end++;
				else {
					st = i;
					end = i + 1;
				}
			} else {
				if (st - end != 0) {
					if(st != 0) 
						ans += nums.charAt(st-1) == '-'? "-" + nums.substring(st, end) + ",":nums.substring(st, end) + ",";
					else
						ans += nums.substring(st, end) + ",";
					st = 0;
					end = 0;
					}
				}
			}
		if (st - end != 0) {
			if(st != 0) 
				ans += nums.charAt(st-1) == '-'? "-" + nums.substring(st, end):nums.substring(st, end);
			else
				ans += nums.substring(st, end);
			}
		return ans;
	}
	public int getCalledCount() {
		return countAddCalls;
	}

	public int add(String numbers) throws NegativeNumberException {
		countAddCalls++;
		try {
			int sum = 0;
			int flag = 0;
			List<Integer> negative = new ArrayList<Integer>();
			if (numbers.length() == 0)
				return 0;
			else {
				String addNumbers = addNumbers(numbers);
				String arr[] = addNumbers.split(",");
				for (String number : arr) {
					int numberToBeAdded = Integer.parseInt(number);
					if(numberToBeAdded < 0) {
						flag = 1;
						negative.add(numberToBeAdded);
					}
					else
						sum += Integer.parseInt(number) > 1000? 0:Integer.parseInt(number);
					}
				if(flag == 1)
					throw new NegativeNumberException("Negative Numbers not allowed: "+negative.toString());
				return sum;
				}
		}catch(NegativeNumberException nx) {
			throw new NegativeNumberException(nx.getMessage());
		}
		}
	}
