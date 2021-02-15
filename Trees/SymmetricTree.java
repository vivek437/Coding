/*

Given a Binary Tree. Check whether it is Symmetric or not, i.e. whether the binary tree is a Mirror image of itself or not.

*/

class GfG
{
    // return true/false denoting whether the tree is Symmetric or not
     public static boolean isSymmetric(Node root)
    {
        if(root == null)
          return true;
        return checkSymmetric(root.left,root.right);
     
    }
    
    public static boolean checkSymmetric(Node left,Node right){
         
         if(left == null && right == null)
             return true;
          
          if(left == null && right != null)
             return false;
           
           if(left != null && right == null)
             return false;
             
          
         if(left.data == right.data){
           return  checkSymmetric(left.left,right.right) && checkSymmetric(left.right,right.left);
         }
         else 
            return false;
           
    }
}
