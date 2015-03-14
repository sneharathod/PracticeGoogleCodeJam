package com.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem The Latin alphabet contains 26 characters and telephones only have
 * ten digits on the keypad. We would like to make it easier to write a message
 * to your friend using a sequence of keypresses to indicate the desired
 * characters. The letters are mapped onto the digits as shown below. To insert
 * the character B for instance, the program would press 22. In order to insert
 * two characters in sequence from the same key, the user must pause before
 * pressing the key a second time. The space character ' ' should be printed to
 * indicate a pause. For example, 2 2 indicates AA whereas 22 indicates B. Input
 * 
 * The first line of input gives the number of cases, N. N test cases follow.
 * Each case is a line of text formatted as
 * 
 * desired_message
 * 
 * Each message will consist of only lowercase characters a-z and space
 * characters ' '. Pressing zero emits a space.
 * 
 * Output
 * 
 * For each test case, output one line containing "Case #x: " followed by the
 * message translated into the sequence of keypresses.
 * 
 * Limits
 * 
 * 1 ≤ N ≤ 100.
 * 
 * Small dataset
 * 
 * 1 ≤ length of message in characters ≤ 15.
 * 
 * Large dataset
 * 
 * 1 ≤ length of message in characters ≤ 1000.
 * 
 * Sample
 * 
 * Input
 * 
 * 4 hi yes foo bar hello world
 * 
 * Output Case #1: 44 444 Case #2: 999337777 Case #3: 333666 6660 022 2777 Case
 * #4: 4433555 555666096667775553
 * 
 * @author srathod
 * 
 */
public class CT9SpellingProblemGoogle {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new InputStreamReader(
					AStoreCreditProblem.class
							.getResourceAsStream("C-small-practice.in.txt")));

			bw = new BufferedWriter(new FileWriter(
					"C-small-practice.out.txt"));

			List<String> numberMap = new ArrayList<String>();
			numberMap.add("abc");// 2
			numberMap.add("def");// 3
			numberMap.add("ghi");// 4
			numberMap.add("jkl");
			numberMap.add("mno");
			numberMap.add("pqrs");
			numberMap.add("tuv");
			numberMap.add("wxyz");
			System.out.println(numberMap);

			Map<String, String> wordMap = new HashMap<String, String>();
			wordMap.put(" ", "0");
			int cnt = 2;
			for (String s : numberMap) {
				// System.out.println("s="+s);
				String[] arr = s.split("");// first one is blank
				// System.out.println("arr len="+arr.length);

				// split s put in map
				for (int k = 1; k < arr.length; k++) {
					// System.out.println("arr["+k+"]="+arr[k]);
					String str = "";
					for (int j = 0; j < k; j++) {
						str += cnt;
					}
					// System.out.println("str="+str);

					wordMap.put(arr[k], str);
				}
				cnt++;
			}
			System.out.println(wordMap);

			// read first number of testcases
			int num = Integer.parseInt(br.readLine());
			System.out.println("num=" + num);

			if (num >= 1 && num <= 100) {

				String msg = null;// blank line
				for (int k = 1; k <= num; k++) {

					msg = br.readLine();// words
					System.out.println("msg=" + msg);
					if (msg != null && !msg.isEmpty()) {
						String[] msgArr = msg.split("");// separate out
														// alphabets n spaces
						System.out.println("msgArr=" + msgArr);
						System.out.println("msgArr.length=" + msgArr.length);

						StringBuffer sb = new StringBuffer();
						String prev = null;
						for (int kr = 1; kr < msgArr.length; kr++) {
							String m  = msgArr[kr];
							String ans = "";
							if (m!=null && !m.isEmpty()) {
								ans = wordMap.get(m);								
							}else{
								ans = wordMap.get(" ");								
							}
							if (prev != null && (prev.contains(ans) || ans.contains(prev))) {
								ans = " " + ans;
							}
							sb.append(ans);
							prev = ans;
						}
						System.out.println("Case #" + k + ": " + sb.toString()
								+ "\n");
						bw.append("Case #" + k + ": " + sb.toString() + "\n");
					} else {
						// bw.append("Case #" + k + ": " + sb.toString() +
						// "\n");
						System.out.println("NUll or empty Case #" + k + ": " + "" + "\n");
						bw.append("Case #" + k + ": " + "" + "\n");
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (br != null)
					br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
