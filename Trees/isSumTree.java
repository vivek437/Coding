/*
https://practice.geeksforgeeks.org/problems/sum-tree/0/?track=md-tree&batchId=144#
*/

class Solution
{
    int f=1;
	boolean isSumTree(Node root)
	{
       getSum(root);
       if(f==1)
         return true;
       else
         return false;
	}
	
	
	int getSum(Node node){
	    if(node == null)
	       return 0;
	    
	    if(node.left == null && node.right == null)
	      return node.data;

	       int x = getSum(node.left);
	       int y = getSum(node.right);
	    
	    if(node.data != x + y)
	        f=0;
	        
	    return node.data + x + y;
	}
}
