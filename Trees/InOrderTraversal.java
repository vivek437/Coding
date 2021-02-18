
/*
https://practice.geeksforgeeks.org/problems/inorder-traversal-iterative/0/?track=md-tree&batchId=144

Given a binary tree. Find the inorder traversal of the tree without using recursion.

*/

class Tree
{
     ArrayList<Integer> ar ;
    // Return a list containing the inorder traversal of the given tree
   
    ArrayList<Integer> inOrder(Node root)
    {
         ar = new ArrayList<Integer>(); 
         inOrderT(root);
         return ar;
    }
      
    void inOrderT(Node root) 
    {
         if(root == null)
          return;
         
         inOrderT(root.left);
         ar.add(root.data);
         inOrderT(root.right);
   }
    
}
