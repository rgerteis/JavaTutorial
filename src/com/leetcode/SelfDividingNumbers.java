package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * A self-dividing number is a number that is divisible by every digit it
 * contains. For example, 128 is a self-dividing number because 128 % 1 == 0,
 * 128 % 2 == 0, and 128 % 8 == 0. Also, a self-dividing number is not allowed
 * to contain the digit zero. Given a lower and upper number bound, output a
 * list of every possible self dividing number, including the bounds if
 * possible.
 * 
 * Example 1:
 * 
 * Input: left = 1, right = 22 Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 
 * Note: The boundaries of each input argument are 1 <= left <= right <= 10000.
 */
public class SelfDividingNumbers {
	
	public int testCases[][] = {{1,22}};

	public static void main(String[] args) {
		
		SelfDividingNumbers s = new SelfDividingNumbers();
		List<Integer> res = new ArrayList<>();
		for (int i=0; i< s.testCases.length; i++) {
			res = s.selfDividingNumbers(s.testCases[i][0], s.testCases[i][1]);
			System.out.println("From:" + s.testCases[i][0] + "| to:" + s.testCases[i][1] + " | " + res);
		}

	}

	public List<Integer> selfDividingNumbers(int left, int right) {

		List<Integer> res = new ArrayList<>();

		for (int i = left; i <= right; i++) {
			int num = i;
			boolean isSelfDeviding = true;
			while (num != 0) {
				int pop = num % 10;
				if(pop == 0 || i % pop != 0) {
					isSelfDeviding = false;
					break;
				}
				num /= 10;
			}
			if(isSelfDeviding) {
				res.add(i);
			}
		}
		return res;
	}

}
