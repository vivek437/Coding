import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'isSimilar' function below.
     *
     * The function is expected to return a BOOLEAN.
     * The function accepts following parameters:
     *  1. STRING_ARRAY sentence_1
     *  2. STRING_ARRAY sentence_2
     *  3. 2D_STRING_ARRAY similarity_matrix
     */

    static class UnionSet{
        HashSet<String> hs;
        UnionSet(){
            this.hs = new HashSet();
        }
        void add(String k){
            this.hs.add(k);
        }
        boolean contains(String k){
            if(hs.contains(k))
                return true;
            else 
                return false;
        }
       void merge(UnionSet a){
           for(int i = 0;i<a.hs.size();i++){
               this.hs.addAll(a.hs);
           }   
       }
        
    }
    public static boolean isSimilar(List<String> sentence_1, List<String> sentence_2, List<List<String>> similarity_matrix) {
         
         System.out.println(sentence_1);
         System.out.println(sentence_2);
         System.out.println(similarity_matrix);
          if(sentence_1.size()!= sentence_2.size())
             return false;
          int r = similarity_matrix.size();
          HashMap<String,UnionSet> hm = new HashMap<>();
          for(int i = 0;i< r;i++){
    
                   String p = similarity_matrix.get(i).get(0);
                   String p1 = similarity_matrix.get(i).get(1);
                   if(!hm.containsKey(p) && !hm.containsKey(p1)){
                        UnionSet temp = new UnionSet();
                        temp.add(p);
                        temp.add(p1);
                        hm.put(p, temp);
                        hm.put(p1, temp);
                   }
                   else if(!hm.containsKey(p) && hm.containsKey(p1)){
                          UnionSet temp =  hm.get(p1);
                          temp.add(p);
                          hm.put(p, temp);
                   }
                   else if(hm.containsKey(p) && !hm.containsKey(p1)){
                          UnionSet temp = hm.get(p);
                          temp.add(p1);
                          hm.put(p1, temp);
                   }
                   else{
                        UnionSet temp = hm.get(p);
                        UnionSet temp1 = hm.get(p);
                        temp.merge(temp1);
                        temp1.merge(temp);
                   }
                 
         }
         
         for(int i = 0;i< sentence_1.size();i++){
             String a = sentence_1.get(i);
             String b = sentence_2.get(i);
             
             if(getWord(a,b,hm))
                continue;
             else
                return false;
         }
         return true;
    }
    
    public static boolean getWord(String a,String b,HashMap<String,UnionSet> hm){
        
        if(!hm.containsKey(a) && !hm.containsKey(b))
             return false;
        
            UnionSet temp1 = hm.getOrDefault(a,new UnionSet());
            UnionSet temp2 = hm.getOrDefault(b,new UnionSet());
            if(temp1.contains(b) || temp2.contains(a))
              return true;
            else 
              return false;
    }
}
