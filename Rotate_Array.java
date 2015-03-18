/*Rotate Array 

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

Show Tags */

public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length ==0 || nums.length ==1){
            return;
        }
        
        k = k % nums.length;
        //Assign memory
        int[] temp = new int[k];
        int n = nums.length;
        for(int i =0; i<k; i++){
            temp[i] = nums[n-k+i];
        }
        
        //move the left to right;
        for(int i = n-k-1; i>=0; i--){
            nums[i+k] = nums[i];
        }
        
        //swap the right to fill the left;
        for(int i=0; i< k ; i++){
            nums[i] = temp[i];
        }
    }
    
    //Time complexity
    private void rotateOnce(int[] nums){
        int temp = nums[nums.length-1];
        for(int i=nums.length -1; i>=1; i--){
            nums[i] = nums[i-1];
        }
        
        nums[0] = temp;
    }
}