package com.online.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_1_TwoSum {
    public int[] twoSumBack(int[] nums, int target) {
        Arrays.sort(nums);
        int beg = 0; int end = nums.length-1;

        while(beg < end) {
            if(nums[beg]+nums[end]==target) {
                return new int[]{beg, end};
            } else if(nums[beg]+nums[end]>target) {
                end--;

            }else if(nums[beg]+nums[end]<target) {
                beg++;
            }
        }
        return new int[]{-1,-1};
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visitedElement = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int elem = nums[i];
            int otherElement = target-elem;
            if(visitedElement.containsKey(otherElement)) {
                return new int[] {visitedElement.get(otherElement), i};
            }
            visitedElement.put(elem, i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LC_1_TwoSum().twoSum(new int[]{3,2,4}, 6)));
    }
}



