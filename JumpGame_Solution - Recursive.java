/*

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

*/

public class Solution {
    private Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
    
    public boolean canJump(int[] array) {
        //recursive or iterative
        if(array == null || array.length == 0){
            return true;    //? or false
        }
        
        return this.isAbleToJump(array, 0);
    }
    
    private boolean isAbleToJump(int[] array, int startIndex){
        if(startIndex >= array.length-1){
            return true;
        }
        
        if(this.map.containsKey(startIndex)){
            return this.map.get(startIndex);
        }
        
        int steps = array[startIndex];
        for(int i=1; i<=steps; i++){
            int j = startIndex+i;
            if(isAbleToJump(array,j)){
                
                this.map.put(startIndex, true);
                
                return true;
            }
        }
        
        this.map.put(startIndex, false);
        return false;
    }
    
}
