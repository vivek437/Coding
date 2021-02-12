/*

https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0/?track=md-string&batchId=144#
Given a string s, recursively remove adjacent duplicate characters from the string s. The output string should not have any adjacent duplicates.

I/P:- 
1
mississippi

O/P:-
m

*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	     
	    Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    in.nextLine();
	    for(int i=0;i<t;i++){
	         String s = in.nextLine();
	         String w = "";
	         int f=0;
	         while(true){
	           String w1 =  removeDuplicates(s,0,w,' ');
	           if(w1.length() == f){
	               System.out.println(w1);
	              break;
	           }
	           else
	              f= w1.length();
	              s=w1;
	              w="";
	         }
	    }
	}
	
	 static String removeDuplicates(String s,int i,String ans,char lastCh){
	      
	        if(i>=s.length()-1){
	            if(lastCh !=s.charAt(i))
	               return ans+s.charAt(i);
	            else
	                return ans;;
	        }
	        if(s.charAt(i) == s.charAt(i+1) || lastCh == s.charAt(i))
	        { 
	            int l = ans.length();
	            return removeDuplicates(s,i+1,ans,s.charAt(i)); 
	        }
	        
	        ans= ans+s.charAt(i);
	        return removeDuplicates(s,i+1,ans,s.charAt(i)); 
	}
}
