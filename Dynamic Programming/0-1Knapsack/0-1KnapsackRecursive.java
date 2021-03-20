/*
https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
*/

class Knapsack 
{ 
    // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         
     if(n == 0 ||  W == 0)
         return 0;
     
     if(wt[n-1]>=W)
        return max(val[n-1] + knapSack(W-wt[n-1],wt,val,n-1),knapSack(W,wt,val,n-1));
     else
        return knapSack(W,wt,val,n-1);
    }

    static int max(int a,int b){
            if(a>b)
              return a;
            else
              return b;
    }
}
