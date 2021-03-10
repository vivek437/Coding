/*

https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/

*/

class Tree
{
   Node ans = null;
	Node lca(Node root, int n1,int n2)
	{
	   
	      FindLCA(root,n1,n2);
	      return ans;
	}
	 int FindLCA(Node node,int n1,int n2){
	      
	      if(node ==  null )
	        return 0;
	 
	      int x = 0; 
	      if(node.data == n1 ||  node.data == n2)
              x=1;
	      int m = FindLCA(node.left,n1,n2);
	      int n = FindLCA(node.right,n1,n2);
	      
	      if(x + m + n == 2 && ans == null)
	          ans = node;
	     return (x+m+n);
	     
	  }
}

