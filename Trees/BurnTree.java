/*
https://practice.geeksforgeeks.org/problems/burning-tree/1/?track=md-tree&batchId=144
*/


class Tree
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    static Queue<Node> q = new LinkedList<Node>();
    static int c=0;
    public static int minTime(Node root, int t) 
    {
          q = new LinkedList<Node>();
          c = 0;
          GetHeight(root,t);
          while(!q.isEmpty()){ 
               Queue<Node> q1 = new LinkedList<Node>();
               while(!q.isEmpty()){
                 Node temp =   q.poll();
                 if(temp.left!=null)
                    q1.add(temp.left);
                 if(temp.right!=null)
                    q1.add(temp.right);
               }
               q = q1;
               c++;
          }
          return c;
    }
    
    static int GetHeight(Node node,int t){
           
           if(node == null)
               return 0;
           
           if(node.data == t){
               if(node.left != null)
                  q.add(node.left);
               if(node.right != null)
                  q.add(node.right);  
               return 1;
           }
           
          
           int  left =   GetHeight(node.left,t);
           int  right =  GetHeight(node.right,t);
           
           if(left == 0 && right == 0)
               return 0;
          
           Queue<Node> q1 = new LinkedList<Node>();
           
           while(!q.isEmpty()){
             Node temp =   q.poll();

             if(temp.left!=null)
                q1.add(temp.left);
             if(temp.right!=null)
                q1.add(temp.right);
           }
           
           if(left == 1 && node.right!=null)
                q1.add(node.right);
           
           if(right == 1 && node.left!=null)
               q1.add(node.left);
          
           q = q1;
           c++;
           return 1;
    }
    
    
}
