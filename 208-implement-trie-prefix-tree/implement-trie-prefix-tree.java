class Trie {
    private Trie[] child;
    private boolean isEnd;
    private Trie root;
    public Trie() {
         child=new Trie[26];
         isEnd=false;
    }
    
    public void insert(String word) {
        if(root==null){
            root=this;
        }
        Trie curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new Trie();
            }
            curr=curr.child[idx];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) {
        if(root==null){
            return false;
        }
        Trie curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null){
                return false;
            }
            curr=curr.child[idx];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        if(root==null){
            return false;
        }
        Trie curr=root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.child[idx]==null){
                return false;
            }
            curr=curr.child[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */