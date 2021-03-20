/*
https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
*/

class Knapsack 
{ 
    // Returns the maximum value that can be put in a knapsack of capacity W 
    static int k[][];
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         k = new int[n+1][W+1];
         return KnapSackKK(W,wt,val,n);
    }
    
    static int KnapSackKK(int W, int wt[], int val[], int n) {
        if(n == 0 ||  W == 0)
           return 0;
        
        if(k[n-1][W] !=0)
             return k[n-1][W];
             
        if(wt[n-1]<=W){
            k[n-1][W] = max(val[n-1] + KnapSackKK(W-wt[n-1],wt,val,n-1),KnapSackKK(W,wt,val,n-1));
            return  k[n-1][W];
        }
        else{
            k[n-1][W] =  KnapSackKK(W,wt,val,n-1);
            return  k[n-1][W];
        }
    }

    static int max(int a,int b){
            if(a>b)
              return a;
            else
              return b;
    }
}
