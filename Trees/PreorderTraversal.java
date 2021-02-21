/*

https://practice.geeksforgeeks.org/problems/preorder-traversal-iterative/1/?track=md-tree&batchId=144#
Given a binary tree. Find the preorder traversal of the tree without using recursion.

*/

class Tree
{
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> preOrder(Node root)
    {
           Stack<Node> st = new Stack<Node>();  
           Stack<Integer> pos = new Stack<Integer>();  
           ArrayList<Integer> ans= new ArrayList<Integer>();
           st.add(root);
           pos.add(0);
           while(!st.isEmpty()){
                Node x = st.peek();
                int y = pos.peek();
            
                if(y==0){
                    ans.add(x.data);
                    pos.pop();
                    pos.push(1);
                    if(x.left != null){
                        st.push(x.left);
                        pos.push(0);
                    }
                }
                else if(y==1){
                    pos.pop();
                    pos.push(2);
                    if(x.right != null){
                        st.push(x.right);
                        pos.push(0);
                    }
                }
                else{
                    st.pop();
                    pos.pop();
                }
           }
           return ans;
    }
}
