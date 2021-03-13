/*

https://practice.geeksforgeeks.org/problems/topological-sort/0/?track=md-graph&batchId=144#

*/



class Solution {
    static int k=0;
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
         
         k=0;
         int vis[] = new int[V];
         int st[] = new int[V];
         int ans[] = new int[V];
         
         while(k<V)
         {
             int ver =  getVertex(vis,V);
             topoSortUtil(vis,st,adj,ver);
             st[k] =  ver;
             k++;
         }
        
         int top = V-1; 
         for(int j=0;j<V;j++){
              ans[j] = st[top];
              top--;
         }
         
         return ans;
    }
    
    static void topoSortUtil(int vis[],int[] st,ArrayList<ArrayList<Integer>> adj,int ver)
    {
        ArrayList<Integer> edL = adj.get(ver);
        for(int j=0;j<edL.size();j++){
           int x = edL.get(j);
           if(vis[x]==0){
               vis[x] = 1;
               topoSortUtil(vis,st,adj,x);
               st[k] =  x;
               k++;
           }
        }
    }
    
    
    static int getVertex(int[] vis,int V){
           
         for(int i=0;i<V;i++){
             if(vis[i]==0){
                 vis[i]=1;
                   return i;
             }
         }
        return -1;
    }
 
}
