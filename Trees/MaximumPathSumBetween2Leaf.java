/*
https://practice.geeksforgeeks.org/problems/maximum-path-sum/1/?track=md-tree&batchId=144
*/

class Tree
{
    int max=Integer.MIN_VALUE;
    int maxPathSum(Node root)
    { 
          max = Integer.MIN_VALUE;
          getSum(root);
          return max;
    } 
    
    
   int getSum(Node root){
           if(root == null)
              return 0;
          
            if(root.left == null && root.right == null)
              return root.data;
              
            if(root.left == null && root.right != null){
                return getSum(root.right)+ root.data;
            }
            
           if(root.left != null && root.right == null){
                 return getSum(root.left) + root.data;
             }
            
           int x = getSum(root.left);  
           int y = getSum(root.right);  
           
           if( x+y+root.data > max )
                max = x + y + root.data;
           
           if(x+root.data> y + root.data)
              return x + root.data;
           else
              return y + root.data; 
    }
}
