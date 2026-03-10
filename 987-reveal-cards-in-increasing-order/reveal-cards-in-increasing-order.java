class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int ans[]=new int[deck.length];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<deck.length;i++){
            q.add(i);
        }
            int i=0;
            boolean flag=true;
            while(q.isEmpty()==false){
            if(flag==true){
                int j=q.poll();
                ans[j]=deck[i];
                i++;
                flag=false;
            }
            else{
                int k=q.poll();
                q.add(k);
                flag=true;
            }
        }
        return ans;
    }
}