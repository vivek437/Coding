
/*
https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1/
*/

class Solution
{
	public Node inorderSuccessor(Node root,Node x)
    {
        return inOrder(root,x);  
    }
    
    Node inOrder(Node node,Node x){
        if(node == null)
            return null;

        Node  y = null;
        
        if(node.data < x.data)
        {
            y = inOrder(node.right,x);
        }
        else if(node.data > x.data)
        {
            y = inOrder(node.left,x);
            if(y == null)
            y = node;
        }
        else
        {
            y = inOrder(node.right,x);
        }
         return y; 
    }
}
