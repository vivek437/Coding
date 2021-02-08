/* https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/bishu-and-his-girlfriend/description/ */


import java.util.*;
class TestClass {
    static int visited[];
    static int level[];
    public static void main(String args[] ) throws Exception {
       
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); 
      
        LinkedList<Integer> ls[]=new LinkedList[n+1];
        for(int i = 0; i <= n; i++) {
            ls[i]  = new LinkedList();
        }
        visited = new int[n+1];
        level = new int[n+1];
        for(int i = 0; i <n-1; i++) {
             int e1 =  in.nextInt();
             int e2 = in.nextInt();
             ls[e1].add(e2);
             ls[e2].add(e1);
        }
        LinkedList<Integer> qu = new LinkedList<Integer>();
        qu.add(1);
        visited[1] = 1;
        level[1] = 1;
        while(!qu.isEmpty()){
            int x = qu.getFirst();
            int currLevel = level[x];
                ListIterator<Integer> list_Iter = ls[x].listIterator(0); 
                while(list_Iter.hasNext()){ 
                   int p = list_Iter.next();
                   if(visited[p] != 1){
                        qu.add(p);
                        visited[p] = 1;
                        level[p] = currLevel+1;
                   }
                } 
            qu.removeFirst();
        }
 
        int q = in.nextInt();
        int min = n+1 , minId = n+1;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<q;i++){
             int x = in.nextInt();
             if(level[x]<=min && minId > x){
                 min = level[x];
                 minId = x;
             }
        }
        System.out.println(minId);
    }
}
