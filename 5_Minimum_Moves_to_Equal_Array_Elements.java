import java.util.Arrays; // i added this to remove red error lines in the code

class Solution {
    public int minMoves2(int[] nums) {
        // int[] num2 = new int[nums.length];
        // int n = nums.length;
        // for(int i=0; i<n; i++){
        // int diff=0;
        // for(int j=0; j<n; j++){
        // if(j==i) continue;
        // diff = diff + Math.abs(nums[i] - nums[j]);
        // }
        // num2[i] = diff;
        // }

        // Arrays.sort(num2);
        // return num2[0];

        Arrays.sort(nums);
        /*
         * this down here will give me the median, mathematically, the absolute
         * difference from the median is the least
         * thus we use that property here
         */
        int median = nums[nums.length / 2];
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        return moves;
    }
}