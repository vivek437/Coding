/*
https://practice.geeksforgeeks.org/problems/construct-tree-1/1/?track=md-tree&batchId=144#

*/
class Solution
{
    static int preOrder,endd;
    public static Node buildTree(int inorder[], int preorder[], int n)
    {     endd = n-1;
          preOrder = 0;
          return Tree(preorder,inorder,0,n-1);
    }
     
    public static Node Tree(int preorderArray[], int inorderArray[], int start, int end) 
    {
        if (start > end || preOrder>endd) {
          return null;
        }
        

        Node node = new Node(preorderArray[preOrder]);
        preOrder++;
    
        if (start == end) {
          return node;
        }
    
        int index = getInorderIndex(node.data, inorderArray, start, end);
    
        node.left = Tree(preorderArray, inorderArray, start, index-1);
        node.right = Tree(preorderArray, inorderArray, index+1, end);
    
        return node;
    }

      private static int getInorderIndex(int val, int in[], int start, int end) {
        for (int i = start; i <= end; i++) {
          if (in[i] == val) {
            return i;
          }
        }
        return -1;
      }
}
