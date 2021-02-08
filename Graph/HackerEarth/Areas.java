
/*
You are given a 2D grid. A '#' represents an obstacle and a '.' represents free space. You need to find the areas of the disconnected components. 
The cells (i+1, j), (i, j+1), (i-1, j), (i, j-1) are the adjacent to the cell (i, j).
https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/areas-0475fb6e/description/
*/

import java.util.*; 
import java.util.HashSet; 
class TestClass {
    static  ArrayList<Integer> ans;
    static int visited[][]; 
    public static void main(String args[] ) throws Exception {
       
        Scanner in = new Scanner(System.in); 
        int t = in.nextInt();

        for(int i=0;i<t;i++){
             int n = in.nextInt();
             int m = in.nextInt();
             char a[][] = new char[n][m];
             visited = new int[n][m];
             in.nextLine();
             
             for(int j=0;j<n;j++){
                 String s=in.nextLine();
                 a[j] = s.toCharArray();
             }

             ans = new ArrayList<Integer>();
             for(int j=0;j<n;j++){
                  for(int k=0;k<m;k++){
                      if( a[j][k] == '.' && visited[j][k]==0){            
                          int x = dfs(a,j,k,n,m);
                          ans.add(x);
                        }
                  }
             }

              System.out.println(ans.size());
              Iterator value = ans.iterator(); 
              while (value.hasNext()) { 
                    System.out.print(value.next()+" "); 
                   } 
              System.out.println();
        }
    }


    static int dfs(char a[][],int j,int k,int n,int m){
               if(a[j][k]!='.')
                 return 0;

               int p=0,q=0,r=0,s=0;
               visited[j][k] = 1;
               if(j-1>=0 && k>=0 && k<m && visited[j-1][k]==0 && a[j-1][k]=='.')
                p = dfs(a,j-1,k,n,m);
               if(j+1<n && k>=0 && k<m && visited[j+1][k]==0  && a[j+1][k]=='.')
                q = dfs(a,j+1,k,n,m);

               if(k-1>=0 && j>=0 && j<n && visited[j][k-1]==0  && a[j][k-1]=='.')
                r = dfs(a,j,k-1,n,m);
               if(k+1<m && j>=0 && j<n && visited[j][k+1]==0  && a[j][k+1]=='.')
                s = dfs(a,j,k+1,n,m);

                return (p+q+r+s+1);
    }

}
