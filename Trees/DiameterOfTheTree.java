/*
https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1/?track=md-tree&batchId=144
Given a Binary Tree, find diameter of it. The diameter of a tree is the number of nodes on the longest path between two end nodes in the tree. 
The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded
(note that there is more than one path in each tree of length nine, but no path longer than nine nodes).

*/
class Tree {
    /* Complete the function to get diameter of a binary tree */
    int max = 0;
    int diameter(Node root) {
      
       int p =  getDiameter(root);
       if(p>max)
          return p;
       else 
          return max;
        
    }
    
    int getDiameter(Node root) {
        
        if(root == null)
           return 0;
           
        int x = getDiameter(root.left);
        int y = getDiameter(root.right);
       
        if(x+y+1>max)
          max= (x+y+1);
        if(x>y)
          return x+1;
        else
          return y+1;
    }
    
}
