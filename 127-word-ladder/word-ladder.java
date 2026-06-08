class Pair{
    String first;
    int second;
    Pair(String _first,int _second){
        this.first=_first;
        this.second=_second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> set=new HashSet<>(wordList);
        set.remove(beginWord);
        while(q.isEmpty()==false){
            String s=q.peek().first;
            int steps=q.peek().second;
            q.poll();
            if(s.equals(endWord)){
                return steps;
            }
            for(int i=0;i<s.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedChar[]=s.toCharArray();
                    replacedChar[i]=ch;
                    String s_=new String(replacedChar);
                    if(set.contains(s_)){
                        q.add(new Pair(s_,steps+1));
                        set.remove(s_);
                    }
                }
            }
        }
        return 0;
    }
}