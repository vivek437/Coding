
/*
https://practice.geeksforgeeks.org/problems/array-to-bst4443/1/*/
class Solution
{
    int k = 0;
    public int[] sortedArrayToBST(int[] nums)
    {
        
        int[] ans = new int[nums.length];
        solve(nums,0,nums.length-1,ans);
        return ans;
    }
    
    void solve(int[] nums, int st, int en,int[] ans){
          if(st>en)
            return;
            
          int mid = (st+en)/2;
          ans[k] = nums[mid];
          k++;
          
          solve(nums,st,mid-1,ans);
          solve(nums,mid+1,en,ans);
          
    }
}
