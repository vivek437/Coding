
/*

https://practice.geeksforgeeks.org/problems/topological-sort/0/?track=md-graph&batchId=144#

Note: -  Creating a incoming edge counter list for each Vertex

*/




class Solution {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    
         int vis[] = new int[V];
         int Inc[] = new int[V];
         int ans[] = new int[V];
         int k=0;
         for(int i=0;i<V;i++){
              ArrayList<Integer> ed = adj.get(i);
              for(int j=0;j<ed.size();j++){
                     int x = ed.get(j);
                     Inc[x] = Inc[x]+1;
              }
         }
         while(k<V){
             int ver =  getVertex(vis,V,Inc);
             vis[ver] = 1;
             ans[k] = ver;
             k++;
             ArrayList<Integer> edL = adj.get(ver);
             for(int j=0;j<edL.size();j++){
                  int x = edL.get(j);
                  Inc[x] = Inc[x]-1;
             }
         }
         return ans;
    }
    
    static int getVertex(int[] vis,int V,int[] Inc){
           
         for(int i=0;i<V;i++){
             if(vis[i]==0 && Inc[i]==0){
                   return i;
             }
         }
        return -1;
    }
 
}
