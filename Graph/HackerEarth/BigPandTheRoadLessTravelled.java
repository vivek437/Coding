/*

https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/big-p-and-the-road-less-travelled-1/description/

GRAPH + DP + DFS

*/

import java.util.*;
class TestClass {
    static int count = 0;
    static int pathCount[];
    public static void main(String args[] ) throws Exception {
      
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); 
      
        LinkedList<Integer> ls[]=new LinkedList[n+1];
       
        for(int i = 0; i <= n; i++) {
            ls[i]  = new LinkedList();
        }

        int[] visited = new int[n+1];
        pathCount = new int[n+1];
             
        while(true){
             int e1 = in.nextInt();
             int e2 = in.nextInt();
             if(e1 == 0 && e2 == 0)
               break;
             ls[e1].add(e2);
        }
        
        dfs(ls,1,n,visited);
        System.out.println(pathCount[1]);
    }

    static int dfs(LinkedList<Integer> ls[],int j,int n,int[] vis){
           if(j==n){
            return 1;
           }
           if(vis[j] == 1)
             return pathCount[j];
           vis[j] = 1;
           int x = 0;
           ListIterator<Integer> list_Iter = ls[j].listIterator(0); 
           while(list_Iter.hasNext()){ 
                  int p = list_Iter.next();
                  x += dfs(ls, p, n, vis);
            } 
            pathCount[j] = x;
            return x;
    }
}
