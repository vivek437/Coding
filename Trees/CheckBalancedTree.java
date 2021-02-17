/*

https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1/?track=md-tree&batchId=144

Given a binary tree, find if it is height balanced or not. 
A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree. 

*/
class Tree
{
    
     /* This function should return tree if passed  tree 
     is balanced, else false. */
    boolean isBalanced(Node root)
    {
	     int x =  getHeight(root);
	     if(x == -1)
	        return false;
	     else
	        return true;
    }
    
    int getHeight(Node node){
        
        if(node == null)
          return 0;
	  
	    int leftHeight = getHeight(node.left);
	    int rightHeight = getHeight(node.right);
	    
	    
	    if(leftHeight == -1 || rightHeight== -1 || leftHeight- rightHeight>1 || rightHeight-leftHeight>1 )
	      return -1;
	    
	    if( leftHeight > rightHeight )
	       return leftHeight+1;
	    else
	       return rightHeight+1;
	       
    }
}
