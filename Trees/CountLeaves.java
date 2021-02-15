/*

https://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1/?track=md-tree&batchId=144

Given a Binary Tree of size N , You have to count leaves in it. For example, there are two leaves in following tree

        1
     /      \
   10      39
  /
5

2

*/


class Tree
{
    int countLeaves(Node root) 
    {
        if(root ==  null)
          return 0;
 
        if(root.left == null && root.right == null)
            return 1;

        return countLeaves(root.left) + countLeaves(root.right); 
    }
}
