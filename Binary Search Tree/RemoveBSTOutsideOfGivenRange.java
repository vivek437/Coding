
/*
https://practice.geeksforgeeks.org/problems/remove-bst-keys-outside-given-range/1
*/
class Solution {
    
    List<Integer> ar = new ArrayList<>();
    Node removekeys(Node root, int l, int r) {
        // code here
        inOrder(root,l,r);
        return formBST(ar,0,ar.size()-1);
       
    }
    
    Node formBST(List<Integer> ar, int st, int en) {
        
        if(st>en)
           return null;
        
        int mid = (st + en)/2;
       
        Node temp = new Node(ar.get(mid));
       
        temp.left = formBST(ar,st,mid-1);
        temp.right = formBST(ar,mid+1,en);
        
        return temp;
    }
    
    
    void inOrder(Node node,int l,int r)
    {
          
          if(node == null)
             return;
             
           inOrder(node.left,l,r);
           
           if(node.data>=l && node.data<=r)
              ar.add(node.data);
              
           inOrder(node.right,l,r);
    }
}

///////

/*
    Node removekeys(Node root, int low, int high) {
        // code here
          if(root == null)
               return null;
        
          if(root.data < low)
                return removekeys(root.right,low,high);
          
          else if(root.data > high)
               return removekeys(root.left,low,high);
          
          else{
              root.left = removekeys(root.left,low,high);
              root.right = removekeys(root.right,low,high);
              return root;
          }
    }
    
   */ 
