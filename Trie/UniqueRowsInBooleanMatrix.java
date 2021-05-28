class GfG
{
    static class TrieNode{
          static TrieNode root; 
          TrieNode[] children = new TrieNode[2];
          boolean isEndOfWord = false;
          
          TrieNode() {
              children = new TrieNode[2];
              isEndOfWord = false;
          }
          
          static void insert(String key){
              
                 int l = key.length();
                 TrieNode crawl = root;
                 
                 for(int i=0;i<l;i++) { 
                     
                     int index = key.charAt(i)-'0';
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
                     int index = key.charAt(i) - '0';
                     if(crawl.children[index] == null){
                         return false;
                      }
                       crawl = crawl.children[index];
                 }
             
                 return (crawl != null && crawl.isEndOfWord);
          }
    }
    
    
    
    static TrieNode tn;
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
    {
           
           tn = new TrieNode();
           
           tn.root = tn;
           ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
           for(int i = 0;i < r; i++){
               String s = "";
               ArrayList<Integer> temp = new ArrayList<>();
               for(int j = 0;j < c; j++){
                      temp.add(a[i][j]);
                      s = s + a[i][j];
                }
                if(tn.Search(s))
                   continue;
                else{
                    tn.insert(s);
                    ans.add(temp);
                }
           }
           return ans;
    }
}
