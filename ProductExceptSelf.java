/*
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        // int[] result = productExceptSelfOSquared(arr);
        int[] result = productExceptSelfON(arr);
        System.out.println(Arrays.toString(result));
    }

    // o^2
    public static int[] productExceptSelfOSquared(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i == j) {
                    continue;
                }
                product *= nums[j];
            }
            result[i] = product;
            product = 1;
        }

        return result;
    }

    // O(N)
    // https://www.youtube.com/watch?v=bNvIQI2wAjk
    public static int[] productExceptSelfON(int[] nums) {
        int prefix = 1;
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i]; 
        }

        return result;
    }
}
