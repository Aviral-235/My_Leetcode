class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int idx=-1;
        int min_dist=Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)){
                idx=i;
                min_dist=Math.min(min_dist,Math.min(Math.abs(idx-startIndex),Math.abs(words.length-Math.abs(idx-startIndex))));
            }
        }
        if(idx==-1){
            return -1;
        }
        return min_dist;
    }
}