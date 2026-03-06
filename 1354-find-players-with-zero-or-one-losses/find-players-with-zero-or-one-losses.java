class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> map_win=new HashMap<>();
        Map<Integer,Integer> map_lose=new HashMap<>();
        int k=0;
        while(k<2){
            if(k==0){
            for(int j=0;j<matches.length;j++){
                    map_win.put(matches[j][k],map_win.getOrDefault(matches[j][k],0)+1);
                }
            }
                else{
                    for(int j=0;j<matches.length;j++){
                        map_lose.put(matches[j][k],map_lose.getOrDefault(matches[j][k],0)+1);
                    }   
                }
                k++;
            }   
                List<Integer> win=new ArrayList<>();
                List<Integer> lose=new ArrayList<>();
                Set<Integer> temp_1=new HashSet<>();
                Set<Integer> temp_2=new HashSet<>();
                for(int i=0;i<matches.length;i++){
                    for(int j=0;j<2;j++){
                        if(map_lose.containsKey(matches[i][j])==true&&map_lose.get(matches[i][j])==1&&temp_1.contains(matches[i][j])==false){
                            lose.add(matches[i][j]);
                            temp_1.add(matches[i][j]);
                        }
                        if(map_win.containsKey(matches[i][j])==true&& map_lose.containsKey(matches[i][j])==false&&temp_2.contains(matches[i][j])==false){
                            win.add(matches[i][j]);
                            temp_2.add(matches[i][j]);
                        }
                    }
                }
                List<List<Integer>> ans=new ArrayList<>();
                Collections.sort(win);
                Collections.sort(lose);
                ans.add(win);
                ans.add(lose);
                return ans;

    }
}