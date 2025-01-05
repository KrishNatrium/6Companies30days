package Amazon;

import java.util.HashMap;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;
        long currSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Initialize first window
        for (int i = 0; i < k; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                currSum += nums[i];
            } else {
                map.put(nums[i], 1);
                currSum += nums[i];
            }
        }

        // Check if the first window is valid
        if (map.size() == k) {
            maxSum = currSum;
        }

        // Slide the window
        for (int i = k; i < n; i++) {
            // for removal from map
            if (map.containsKey(nums[i - k])) {
                if (map.get(nums[i - k]) == 1) {
                    map.remove(nums[i - k]);
                    currSum -= nums[i - k];
                } else {
                    map.put(nums[i - k], map.get(nums[i - k]) - 1);
                    currSum -= nums[i - k];
                }
            }

            // for putting in map
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                currSum += nums[i];
            } else {
                map.put(nums[i], 1);
                currSum += nums[i];
            }

            // Check if the current window is valid and update maxSum
            if (map.size() == k) {
                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }
}
