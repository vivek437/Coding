
Class Node {

   int data;
   List<Node> children;
   Node parent;
  
   Node (int data){
       this.data = data;
       this.children = new ArrayList<Node>();
       this.parent = null;
   }
}


Class TestClass{
   
   public static void main(String[] args){
      
       Scanner in = new Scanner(System.in);
       int n = in.nextInt();
       int m = in.nextInt();
     
       int rootData = in.nextInt();
       Node root = new Node(root);
       int tn = n;
      
       Queue<Node> q = new LinkedList<Node>();
       q.add(root);
       while(tn>0){
           Node currParent = q.poll();
           for(int i=0;i<m;i++){
                int childD = in.nextInt();
                Node child = new Node(childD);
                child.parent = currParent;
                temp.children(child);
                q.add(child);
           }
         tn--;
       }
   }
}
