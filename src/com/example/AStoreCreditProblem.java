package com.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * Problem

You receive a credit C at a local store and would like to buy two items. You first walk through the store and create a list L of all available items. From this list you would like to buy two items that add up to the entire value of the credit. The solution you provide will consist of the two integers indicating the positions of the items in your list (smaller number first).

Input

The first line of input gives the number of cases, N. N test cases follow. For each test case there will be:

    One line containing the value C, the amount of credit you have at the store.
    One line containing the value I, the number of items in the store.
    One line containing a space separated list of I integers. Each integer P indicates the price of an item in the store.
    Each test case will have exactly one solution.

Output

For each test case, output one line containing "Case #x: " followed by the indices of the two items whose price adds up to the store credit. The lower index should be output first.

Limits

5 ≤ C ≤ 1000
1 ≤ P ≤ 1000

Small dataset

N = 10
3 ≤ I ≤ 100

Large dataset

N = 50
3 ≤ I ≤ 2000 

Input	
3
100
3
5 75 25
200
7
150 24 79 50 88 345 3
8
8
2 1 9 4 4 56 90 3

Output
Case #1: 2 3
Case #2: 1 4
Case #3: 4 5
 * @author srathod
 *
 */
public class AStoreCreditProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new InputStreamReader(AStoreCreditProblem.class.getResourceAsStream("A-small-practice.in.txt")));
					
			bw = new BufferedWriter(new FileWriter(
					"A-small-practice.out.txt"));
			// read first number of testcases
			int num = Integer.parseInt(br.readLine());
			if (num >= 3 && num <= 100) {
				for (int k = 1; k <= num; k++) {
					
					String storeCredit  = br.readLine();
					int storeCreditAmount = Integer.parseInt(storeCredit);
					
					System.out.println("" + storeCredit);
					
					String items  = br.readLine();
					int numItems = Integer.parseInt(items);
					System.out.println("" + numItems);
					
					//List of item values
					String itemVals  = br.readLine();
					
					//5 ≤ C ≤ 1000
					//1 ≤ P ≤ 1000 
					String[] arr = itemVals.split(" ");// split using single space
					String answer = null;
					
					//fill int arr
					int[] intArr = new int[arr.length];
					for(int i = 0; i < arr.length; i++){
						intArr[i]=Integer.valueOf(arr[i]);
					}
					
					for (int i = 0; i < arr.length; i++) {
						for (int j = 0; j < arr.length; j++) {
							if(i == j){
								continue;//skip
							}
							
							if((intArr[i]+intArr[j]) == storeCreditAmount){
								if(i > j){
									answer = (j+1) + " "+ (i+1);
								}
								else{
									answer = (i+1) + " "+ (j+1);
								}
								break;
							}
						}
						
					}
					
					System.out.println("Case #" + k + ": " + answer
							+ "\n");
					bw.append("Case #" + k + ": " + answer + "\n");
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
