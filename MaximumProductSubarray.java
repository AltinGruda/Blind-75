/*
 * 
 * Given an integer array nums, find a 
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] array = {2, 3, -2, 4};
        System.out.println(maxProduct(array));
    }

    public static int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
            prefix *= nums[i];
            suffix *= nums[nums.length - i - 1];
            answer = Math.max(answer, Math.max(prefix, suffix));
        }
        
        return answer;
    }
}
