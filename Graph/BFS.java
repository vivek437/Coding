
/*

https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1/?track=md-graph&batchId=144

*/

class Solution
{
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
          ArrayList<Integer> ans = new ArrayList<Integer>();
          Queue<Integer> qu = new LinkedList<Integer>();
          int vis[] = new int[V];
          qu.add(0);
          ans.add(0);
          vis[0] = 1;
          while(!qu.isEmpty()){
               int t = qu.poll();
               ArrayList<Integer> v = adj.get(t);
               for(int i=0;i<v.size();i++){
                    int x = v.get(i);
                    if(vis[x] != 1)
                    {
                        vis[x] = 1;
                        ans.add(x);
                        qu.add(x);
                    }
               }
          }
          return ans;
    }
}
