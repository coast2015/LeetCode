/**
Sum Root to Leaf Numbers

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.


 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        List<Integer> path = new ArrayList<Integer>();
        this.findLeafs(root, path);
        
        return sum;
    }
    
    
    private void findLeafs(TreeNode node, List<Integer> path){
        path.add(node.val);
        
        if(node.left ==null && node.right == null){     //leaf node
            this.addToSum(path);
            
            path.remove(path.size()-1);  // remoe it
            return;
        }
        
        if(node.left!=null){
            this.findLeafs(node.left, path);
        }
        
        if(node.right!=null){
            this.findLeafs(node.right, path);
        }
        
        path.remove(path.size()-1);
        return;
        
    }
    
    private void addToSum(List<Integer> path){
        int temp = 0;
        for(Integer num: path){
            temp = temp*10 + num;
        }
       
        sum += temp;
        
        return;
        
    }
}