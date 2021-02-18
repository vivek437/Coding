/*
https://practice.geeksforgeeks.org/problems/inorder-traversal-iterative/0/?track=md-tree&batchId=144#

Approach:  Maintaining two pointers one for nodes and other with their flags. At each node flags are maintained :
flag - 0  - Pushed in stack
flag - 1  - Left Subtree Iterated
flag - 2  - Right Subtree Iterated

*/
class Tree
{
    // Return a list containing the inorder traversal of the given tree
   
    ArrayList<Integer> inOrder(Node root)
    {
         ArrayList<Integer> ar = new ArrayList<Integer>(); 
         Stack<Node> st = new Stack<Node>();
         Stack<Integer> oper = new Stack<Integer>();
        
         st.push(root);
         oper.push(0);

         while(!st.isEmpty()){
               
                Node x = st.peek();
                int y  =  oper.peek();
                if(y == 0) {
                    oper.pop();
                    oper.push(1);
                    if( x.left!=null){
                        st.push(x.left);
                        oper.push(0);
                        continue;
                    }
                }
                else if(y == 1){
                   ar.add(x.data);
                   oper.pop();
                   oper.push(2);
                   if( x.right!=null){
                        st.push(x.right);
                        oper.push(0);
                        continue;
                    }
                }
                else{
                  st.pop();
                  oper.pop();
                  continue;
                }
          }
          return ar;
    }
   
}
