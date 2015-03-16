package com.example;

import java.util.Arrays;

public class EmpPointProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input1 = { 15, 3, 15, 3 };
		System.out.println(getPosition(input1));

		/*
		 * int[] input2 = {15,3,-15,3};
		 * //System.out.println(getPosition(input2));
		 */
	}

	public static String getPosition(int[] input1) {
		int n = input1.length;
		String result = "invalid";
		int[] resultInt = new int[n];

		// Write code here
		for (int i = 0; i < n; i++) {// all items in input
			//System.out.println("i=" + i + " input = " + input1[i]);
			// check if first item has anything
			if (input1[i] <= 0) {
				return result;
			}
			int count = 0;
			int matchIndex = -1;

			for (int j = i - 1; j >= 0; j--) {
				//System.out.println("j=" + j + " input = " + input1[j]);

				if (input1[i] == input1[j]) {
					//System.out.println("same " + input1[j] + " at j =" + j + " and i=" + i);
					matchIndex = j;
					break;
				}
			}
			//System.out.println("matchIndex=" + matchIndex);
			if (matchIndex != -1) {
				// reverse check

				for (int l = i, k = matchIndex; l >= 0 && k >= 0; l--,k--) {
					//System.out.println("k=" + k + "\t l=" + l);
					if (input1[k] != input1[l]) {
						//System.out.println("exiting inner loop");
						break;
					}
					count++;
					
				}

			}
			//System.out.println("count=" + count);

			resultInt[i] = count;
		}

		result = Arrays.toString(resultInt).replace("[", "").replace("]", "");
		return result;
	}
}
