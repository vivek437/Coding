/*
https://practice.geeksforgeeks.org/problems/minimum-depth-of-a-binary-tree/0/?track=md-tree&batchId=144
Given a binary tree, find its minimum depth.

*/


class Tree
{
    int min = Integer.MAX_VALUE;
	int minDepth(Node root)
	{
	    if(root == null)
	          return 0;
	    getDepth(root,1);
	    return min;
	}
	
	void getDepth(Node node,int depth){
	    
	    if(node == null)
	       return;
	    
	    if(node.left == null && node.right == null){
	           if(depth<min)
	              min = depth;
	    }
	    if(node.left != null)
	      getDepth(node.left,depth+1);
	    if(node.right != null)
	      getDepth(node.right,depth+1);
	}
}

///// Without using extra Variable


class Tree
{
	int minDepth(Node root)
	{
	    if(root==null) return 0;
	    if(root.left==null && root.right==null) return 1;
	    if(root.left==null) return minDepth(root.right)+1;
	    if(root.right==null) return minDepth(root.left)+1;
	    return Math.min(minDepth(root.left), minDepth(root.right))+1;
	}
}

