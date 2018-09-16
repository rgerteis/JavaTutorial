package com.leetcode;

class LowerCase {

	public String toLowerCase(String str) {
		// this would be easy solution
		// return str.toLowerCase();

		char[] phrase = str.toCharArray();

		for (int i = 0; i < phrase.length; i++) {
			if (phrase[i] >= 'A' && phrase[i] <= 'Z') {
				phrase[i] = (char) (((int) phrase[i]) + 32);
			}
		}
		return new String(phrase);
	}

	public static void main(String args[]) {
		LowerCase s = new LowerCase();
		String res = "";

		// Few test cases
		res = s.toLowerCase("Hello");
		assert (res.equals("hello"));
		System.out.println(res);

		res = s.toLowerCase("RachelKissesChandler");
		assert (res.equals("rachelkisseschandler"));
		System.out.println(res);
	}
}
