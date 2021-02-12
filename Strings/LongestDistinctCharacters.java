/*  

https://practice.geeksforgeeks.org/problems/longest-distinct-characters-in-string/0/?track=md-string&batchId=144#

Given a string S, find length of the longest substring with all distinct characters.
For example, for input "abca", the output is 3 as "abc" is the longest substring with all distinct characters.

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	     
	    Scanner in = new Scanner(System.in);
	    int t=in.nextInt();
	    in.nextLine();
	    for(int i=0;i<t;i++){
	        String s = in.nextLine();
	        
	        int l = s.length();
	        int start = 0;
	        HashSet<Character> hs = new HashSet<Character>();
	        int max=0;
	        for(int j=0;j<l;j++){
	            char ch = s.charAt(j);
	            if(!hs.contains(ch)){
	                 hs.add(ch);
	                 if(j-start+1>max)
	                    max = (j-start+1);
	            }
	           else{
	           
	               while(start<j){
	                  char ch1= s.charAt(start);
	                  if(ch1!=ch){
	                    hs.remove(ch1);
	                    start++;
	                  }
	                  else
	                  {
	                      start++;
	                      break;
	                  }
	               }
	            }
	        }
	        System.out.println(max);
	    }
	}
}
