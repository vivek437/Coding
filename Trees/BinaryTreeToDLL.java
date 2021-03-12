/*
https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1/?track=md-tree&batchId=144

*/

class Solution
{
    Node head, prev = null;
  
    Node bToDLL(Node root)
    {
        convert(root);
        return head;
    }
    
   void convert(Node root){
        
        if(root == null)
           return;
           
        convert(root.left);
        if(head == null)
           head = root;
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convert(root.right);
    }
}
