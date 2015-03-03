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
