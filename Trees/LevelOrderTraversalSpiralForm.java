/*
Complete the function to find spiral order traversal of a tree. For below tree, function should return 1, 2, 3, 4, 5, 6, 7.
https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/0/?track=md-tree&batchId=144#

Solved using 2 stacks
*/
class Spiral
{
      ArrayList<Integer> findSpiral(Node root) 
      { 
          ArrayList<Integer> ans = new  ArrayList<Integer>();
          Stack<Node> st1 = new Stack<>(); 
          Stack<Node> st2 = new Stack<>();
          if(root ==  null)
            return ans;
          st2.push(root);
          while(true){
              if(st2.isEmpty() && st1.isEmpty())
                 break;
   
                  while(!st1.isEmpty()){
                     Node p =  st1.pop();
                     ans.add(p.data);
                     if(p.left!=null)
                           st2.push(p.left);
                     if(p.right!=null)
                           st2.push(p.right);   
                  }

                  while(!st2.isEmpty()){
                      Node p =  st2.pop();
                      ans.add(p.data);
                     
                      if(p.right!=null)
                           st1.add(p.right); 
                           
                      if(p.left!=null)
                           st1.add(p.left);
                  }
          }
          return ans;
      }
}
