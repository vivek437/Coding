
/*
https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/0/
*/
class Solution
{
    // root : the root Node of the given BST
    // target : the target sum
    HashSet<Integer> hs = new HashSet<Integer>();
    public int isPairPresent(Node root, int target)
    {
         
          if(inOrder(root,target))
              return 1;
          else
             return 0;
          
    }
    
    boolean inOrder(Node node,int target)
    {
           if(node == null)
             return false;
             
           if(inOrder(node.left,target))
              return true;

           int p = node.data;
           if(hs.contains(target-p))
               return true;
  
           hs.add(node.data);
           if(inOrder(node.right,target))
               return true;
           
           return false;
    }
}
