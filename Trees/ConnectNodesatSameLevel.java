
/*
https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/0/?track=md-tree&batchId=144#

*/
class Solution
{
    /*
    Node class is Defined as follows:
    class Node{
        int data;
        Node left;
        Node right;
        Node nextRight;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
            nextRight = null;
        }
    }
    */
    public void connect(Node root)
    {
          Queue<Node> q = new LinkedList<Node>(); 
          Queue<Node> q1 = new LinkedList<Node>(); 
          int f=0;
          Node lastNode = null;
          q.add(root);
          while(true){
              Node temp = q.poll();
              if(lastNode!=null)
                 lastNode.nextRight = temp;
              
              lastNode = temp;
              
              if(temp.left!=null){
                  q1.add(temp.left);
              }
              if(temp.right!=null){
                  q1.add(temp.right);
              }
              
              if(q.isEmpty()){
                  if(q1.isEmpty()){
                      break;
                  }
                  else{
                       q = q1;
                       q1 = new LinkedList<Node>(); 
                       lastNode = null;
                  }
              }
          }
    }
}
