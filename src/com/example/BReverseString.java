package com.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * Problem

Given a list of space separated words, reverse the order of the words. Each line of text contains L letters and W words. A line will only consist of letters and space characters. There will be exactly one space character between each pair of consecutive words.

Input

The first line of input gives the number of cases, N.
N test cases follow. For each test case there will a line of letters and space characters indicating a list of space separated words. Spaces will not appear at the start or end of a line.

Output

For each test case, output one line containing "Case #x: " followed by the list of words in reverse order.

Limits

Small dataset

N = 5
1 ≤ L ≤ 25

Large dataset

N = 100
1 ≤ L ≤ 1000

Sample

Input
3
this is a test
foobar
all your base

Output
Case #1: test a is this
Case #2: foobar
Case #3: base your all
 * @author srathod
 *
 */
public class BReverseString {
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new InputStreamReader(BReverseString.class.getResourceAsStream("B-small-practice.in.txt")));
			bw = new BufferedWriter(new FileWriter(
					"B-small-practice.out.txt"));
			String str = null;
			// read first number of lines
			int num = Integer.parseInt(br.readLine());
			if (num >= 1 && num <= 25) {
				for (int j = 0; j < num; j++) {
					str = br.readLine();
					System.out.println("" + str);
					String[] arr = str.split(" ");// split using single space
					StringBuffer sb = new StringBuffer();
					for (int i = arr.length - 1; i >= 0; i--) {
						sb.append(arr[i] + " ");
					}
					System.out.println("Case #" + j + ": " + sb.toString().trim()
							+ "\n");
					bw.append("Case #" + j + ": " + sb.toString().trim() + "\n");
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
