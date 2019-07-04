package com.javacourse.exercises.codingbat;

/**
 * Exercise on codingbat.com: https://codingbat.com/prob/p136585
 * 
 * @author Lucio Benfante
 *
 */
public class CenteredAverage {
	public int centeredAverage1(int[] nums) {
		int sum = 0;
		int min = Math.min(nums[0], nums[1]);
		int max = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] < min) {
				sum += min;
				min = nums[i];
			} else if (nums[i] > max) {
				sum += max;
				max = nums[i];
			} else {
				sum += nums[i];
			}
		}
		return sum / (nums.length - 2);
	}

	/**
	 * 
	 * @author Jacopo C.
	 */
	public int centeredAverage(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			min = Math.min(nums[i], min);
			max = Math.max(nums[i], max);
			sum += nums[i];
		}
		return (sum - min - max) / (nums.length - 2);
	}
}
