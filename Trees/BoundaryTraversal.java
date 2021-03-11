/*
https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1/?track=md-tree&batchId=144#
*/
class Solution
{
    ArrayList <Integer>  ans = new ArrayList <Integer>();
	ArrayList <Integer> printBoundary(Node node)
	{
	    ans.add(node.data);
	    GetLeftBoundary(node.left);
	    GetLeaf(node);
	    GetRightBoundary(node.right);
	    return ans;
	}
	
    void GetLeftBoundary(Node node){
	    if(node == null)
	       return;
	   
	    if(node.left!=null){
	        ans.add(node.data);
	        GetLeftBoundary(node.left);
	    }
	    else if(node.right!=null){
	        ans.add(node.data);
	        GetLeftBoundary(node.right);
	    }
	}
	
	 void GetLeaf(Node node){
	    if(node == null)
	       return;
	    if(node.left == null && node.right == null){
	       ans.add(node.data);
	       return;
	    }
	    GetLeaf(node.left);
	    GetLeaf(node.right);
	}
	
	void GetRightBoundary(Node node){
	    if(node == null)
	       return;
	   
	    if(node.right!=null){
	        GetRightBoundary(node.right);
	        ans.add(node.data);
	    }
	    else if(node.left!=null){
	        GetRightBoundary(node.left);
	        ans.add(node.data);
	    }
	     
	}
}
