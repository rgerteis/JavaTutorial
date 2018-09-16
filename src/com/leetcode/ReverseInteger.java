package com.leetcode;

/**
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of
 * this problem, assume that your function returns 0 when the reversed integer
 * overflows.
 * 
 * @author aRGee
 *
 */
public class ReverseInteger {

	public int[][] testCases = { { 123, 321 }, { -123, -321 }, { 120, 21 }, { 1534236469, 0 } };

	public static void main(String[] args) {

		ReverseInteger r = new ReverseInteger();
		int result = 0;

		for (int i = 0; i < r.testCases.length; i++) {
			result = r.reverse(r.testCases[i][0]);
			assert (result == r.testCases[i][1]) : "Expected:" + r.testCases[i][1] + " but result was " + result;
			System.out.println("Input: " + r.testCases[i][0] + " | Output:" + result);
		}

		for (int i = 0; i < r.testCases.length; i++) {
			result = r.reverseAlt(r.testCases[i][0]);
			assert (result == r.testCases[i][1]) : "Expected:" + r.testCases[i][1] + " but result was " + result;
			System.out.println("Input: " + r.testCases[i][0] + " | Output:" + result);
		}
	}

	public int reverse(int x) {

		int result;
		boolean isNegative = false;
		String str = "";

		if (x < 0) {
			x = x * -1;
			isNegative = true;
		}

		char[] chars = String.valueOf(x).toCharArray();

		for (int i = chars.length - 1; i >= 0; i--) {
			str += chars[i];
		}
		try {
			result = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return 0;
		}
		if (isNegative) {
			result = result * -1;
		}
		return result;
	}

	/**
	 * alternative solution from leetcode ranking as the fastest solution
	 * 
	 * @param x
	 * @return
	 */
	public int reverseAlt(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}

}
