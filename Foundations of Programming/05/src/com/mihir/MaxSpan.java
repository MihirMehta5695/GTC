package com.mihir;

/**
 * Consider the leftmost and righmost appearances of some value in an array. We'll say that the "span" is the number of elements between the two inclusive. A single value has a span of 1. Returns the largest span found in the given array. (Efficiency is not a priority.)
 * <p>
 * <p>
 * maxSpan([1, 2, 1, 1, 3]) → 4
 * maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
 * maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
 */

public class MaxSpan {

    public static void main(String[] args) {
        int[] myArray = {1, 4, 2, 1, 4, 4, 4};
        System.out.println(new MaxSpan().maxSpan(myArray));

    }

    public int maxSpan(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxSpan = 0;
        int startIndex = 0, endIndex = nums.length - 1;
        while (startIndex < nums.length) {
            endIndex = nums.length - 1;
            while (endIndex >= startIndex) {
                if ((nums[startIndex] == nums[endIndex])) {
                    int currentSpan = endIndex - startIndex;
                    if (maxSpan < currentSpan) {
                        maxSpan = currentSpan;
                    }
                }
                endIndex--;
            }
            startIndex++;
        }
        return maxSpan + 1;
    }
}
