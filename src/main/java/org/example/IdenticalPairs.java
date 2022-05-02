package org.example;

public class IdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
        int sum = 0;
        int shift = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - shift; j++) {
                if(nums[i] == nums[j + shift]){
                    sum++;
                }
            }
            shift++;
        }
        return sum;
    }
}
