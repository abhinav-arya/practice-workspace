/*
 * Given an array of integers and a value, determine if there are any two integers 
 * in the array whose sum is equal to the given value. Return true if the sum exists 
 * and return false if it does not.

	Consider this array and the target sums: 
			[5 7 1 2 8 4 3]
			
	Target Sum - 10: 7,3 and 8,2
	Target Sum - 19: Not Found
 */

package com.practice.amz;

import java.util.HashSet;
import java.util.Set;

public class TargetSumInArray {

	static boolean targetSum(int[] arr, int t_sum) {
		
		Set<Integer> foundVals = new HashSet<Integer>();
		boolean result = false;
		
		for (int i = 0; i < arr.length; i++) {
			if (foundVals.contains(t_sum - arr[i])) {
				System.out.println("[" + (t_sum - arr[i]) + ", " + arr[i] + "]");
				result = true;
			}
			foundVals.add(arr[i]);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {5, 7, 1, 2, 8, 4, 3};
		int target_sum = 10;
		
		System.out.print(targetSum(arr, target_sum));
	}
}
