package com.leetcode.twosum;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i < nums.length; i++) {
            for (int j=0; j < nums.length; j++) {
                // System.out.println(nums[i] + ":" + nums[j] + ":" + target);
                if (i==j) {
                    break;
                } else if (nums[i] + nums[j] == target) {
                    return new int[] {i , j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");   
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int arr1[] = {2, 7, 11, 15};
        int arr2[] = {3,2,4};
        int res[] = new int[2];
        res = s.twoSum(arr1 ,9);         
        System.out.println("Output: " + res[0] + ":" + res[1]);
        assert res[0] == 0 && res[1] == 1;

        res = s.twoSum(arr2 ,6);         
        System.out.println("Output: " + res[0] + ":" + res[1]);
        assert res[0] == 1 && res[1] == 2;

    }
}