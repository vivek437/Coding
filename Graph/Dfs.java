/*

https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1/?track=md-graph&batchId=144

*/

class Solution
{
    int vis[];
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
          vis = new int[V];
          ArrayList<Integer> ans= new ArrayList<Integer>();
          ans.add(0);
          vis[0] = 1;
          dfs(0,adj,ans);    
          return ans;
    }
    
    public void dfs(int vertex,ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans){
             ArrayList<Integer> v = adj.get(vertex);
             for(int i=0;i<v.size();i++){
                 int x = v.get(i);
                 if(vis[x]!=1)
                 {
                     vis[x] = 1;
                     ans.add(x);
                     dfs(x,adj,ans);
                 }
             }
    }
}
