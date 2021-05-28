
class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
       

       int k = -1;

       int i = N-2;
       for(i = N-2 ; i>=0; i-- ){

            if(arr[i+1]<arr[i]){
                continue; 
            }
            else{
                k = i;
                break;
            }
       }
       
       if(k == -1)
       {
           
            Arrays.sort(arr);
            List<Integer> list = new ArrayList<>();
      
            for (Integer t : arr) {
       
                list.add(t);
            }
  
        return list;
           
       }
        int min = Integer.MAX_VALUE;
        int pos  = -1;
        for(int j = i ; j<N; j++ ){
            if(arr[j]>arr[k] && arr[j]<min){
               min = arr[j];
               pos = j;
            }
        }
        
        int t1 = arr[k];
        arr[k] = arr[pos];
        arr[pos] = t1;
        
        Arrays.sort(arr, k+1 , N);
        List<Integer> list = new ArrayList<>();
  
        for (Integer t : arr) {
   
            list.add(t);
        }
  
        return list;
       
    }
}
