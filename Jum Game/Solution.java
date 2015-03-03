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