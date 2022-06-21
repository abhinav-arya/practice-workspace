/*
Find the missing number in the array
You are given an array of positive numbers from 1 to n, 
such that all numbers from 1 to n are present except one number x. 
You have to find x. The input array is not sorted. 
Look at the below array and give it a try before checking the solution.

3 7 1 2 8 4 5
n = 8, missing number = 6
*/

package com.practice.amz;

public class MissingNumber {
	
	public static void main(String[] args) {
		int[] input_array = {3, 7, 1, 2, 8, 4, 5};
		System.out.print(getMissingNumber(input_array));
	}

	static int getMissingNumber(int[] arr) {
		
		int sum = 0, exp_sum, len = arr.length + 1;
	
		exp_sum = len/2 * (1 + len);
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
	
		return exp_sum - sum;
	}
}
