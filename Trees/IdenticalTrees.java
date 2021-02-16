/* 
https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/0/?track=md-tree&batchId=144
Given two binary trees, the task is to find if both of them are identical or not.

*/
class Tree
{
	boolean isIdentical(Node root1, Node root2)
	{
	     if(root1 == null && root2==null)
	        return true;
	    
	     if(root1 == null || root2 == null)
	        return false;
	     
	     if(root1.data != root2.data)
	        return false;
	      
	     return isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right);
	}
	
}
