

/*
https://www.interviewbit.com/problems/majority-element/
*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int majorityElement(final int[] A) {
        
         int major = A[0],count = 1;
         for (int i=1;i<A.length;i++){
            
            if(A[i] == major)
              count++;
            else{
                count--;
                if(count == 0){
                     major = A[i];
                     count = 1;
                }
            }
         }
         return major;
    }
}
