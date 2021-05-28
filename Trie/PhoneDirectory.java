
class Solution{
     static class TrieNode{
          static TrieNode root; 
          TrieNode[] children = new TrieNode[26];
          boolean isEndOfWord = false;
          
          TrieNode() {
              children = new TrieNode[26];
              isEndOfWord = false;
          }
          
          static void insert(String key){
              
                 int l = key.length();
                 TrieNode crawl = root;
                 
                 for(int i=0;i<l;i++) { 
                     
                     int index = key.charAt(i)-'a';
                     if(crawl.children[index] == null){
                          crawl.children[index] = new TrieNode();
                      }
                      crawl = crawl.children[index];
                 }
                crawl.isEndOfWord = true;
          }
          
          static boolean Search(String key){
                int l = key.length();
                 TrieNode crawl = root;
                 
                 for(int i=0;i<l;i++) { 
                     int index = key.charAt(i) - 'a';
                     if(crawl.children[index] == null){
                         return false;
                      }
                       crawl = crawl.children[index];
                 }
             
                 return (crawl != null && crawl.isEndOfWord);
          }
          
          static  ArrayList<String> prefixSearch(String key){
                 int l = key.length();
                 TrieNode crawl = root;
                 ArrayList<String> ar = new ArrayList<String>();
                 
                 for(int i=0;i<l;i++) { 
                     int index = key.charAt(i) - 'a';
                     if(crawl.children[index] == null){
                         ar.add("0");
                         return ar;
                      }
                       crawl = crawl.children[index];
                 }
                 
                if(crawl != null){
                
                   getAllWords(crawl,ar,key);
                }
                return ar;
              
          }
          
          
          static ArrayList<String> getAllWords(TrieNode node, ArrayList<String> ar,String key)
          {
               if(node == null)
                  return ar;
                  
              if(node.isEndOfWord)
                      ar.add(key);
                       
               for(int index=0; index<26;index++) { 
                   
                    if(node.children[index] != null){
                             getAllWords(node.children[index],ar,key+(char)(index+97));
                     }
               }
               return ar;
          }
    }
    
    
    
    static TrieNode tn;
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
          tn = new TrieNode();
           
           tn.root = tn;
           
           for(int i=0;i<n;i++){
               tn.insert(contact[i]);  
           } 
           
           ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
           
           int l = s.length();
           String w = "";
           for(int i = 0;i < l ;i++){
               w = w + s.charAt(i);
               ans.add(tn.prefixSearch(w));
           }
           return ans;
    }
}
