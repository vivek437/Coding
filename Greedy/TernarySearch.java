/*
https://www.geeksforgeeks.org/ternary-search/
*/


class Solution{

    static int ternarySearch(int arr[], int N, int k)
    {
        
          
           int st =  0, en =  N-1;
           int p1  = 0 , p2 = 0;
           int f =-1;
           int c = 0;
           while(st<=en){
               p1 = st + (en - st) / 3;
               p2 = en - (en - st) / 3;
               
               if(arr[p1]<k){
                   st = p1 + 1;
               }
               if(arr[p1]>k){
                   en = p1 - 1;
               }
               if(arr[p2]>k){
                   en = p2 - 1;
               }
               if(arr[p2]<k)   
                   st = p2 + 1;
             
               if(arr[p1] == k){
                   f = p1;
                   break;
               }
               if(arr[p2] == k){
                   f = p2;
                   break;
               }
           }
           return f>=0?1:f;
        
    }
}
