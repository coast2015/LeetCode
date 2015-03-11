/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/
public class Solution {
    
    public boolean canJump(int[] array) {
        //recursive or iterative
        if(array == null || array.length == 0 || array.length ==1){
            return true;    //? or false
        }
        
        boolean[] jumps = new boolean[array.length];
        
        //init jumps array
        for(int i=0; i< array.length; i++){
            int k = array[i];
            if(i+k>=array.length-1){
                jumps[i] = true;
            }
        }
        
        if(jumps[0]){
            return true;
        }
        
        
        //Try backward search again
        for(int i=array.length-2; i>=0; i--){
            if(jumps[i] == true){
                continue;
            }
            int j = array[i];
            for(int k =j; k >=1; k--){
                if(jumps[i+k]){
                    jumps[i] = true;
                    break;
                }
            }
            
            jumps[i] = false;
        }
        
        return jumps[0];
    }
    

}