import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dupe = new int[n];

        int i = (n - 1) / 2;
        int j = n - 1;
        //
        for (int k = 0; k < n; k++) {
            if (k % 2 == 0) {
                dupe[k] = nums[i--]; // Fill even index
            } else {
                dupe[k] = nums[j--]; // Fill odd index
            }
        }
        System.arraycopy(dupe, 0, nums, 0, n);
    }
}
