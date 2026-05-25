class Solution {
    public boolean bfs(char arr[],int x,int minj,int maxj){
        Queue<Integer> q=new LinkedList<>();
        q.add(x);
        int farthest=0;
        while(q.isEmpty()==false){
            int idx=q.poll();
            int start=Math.max(idx+minj,farthest+1);
            int end=Math.min(idx+maxj,arr.length-1);
            for(int i=start;i<=end;i++){
                if(arr[i]=='0'){
                    if(i==arr.length-1){
                    return true;
                    }
                    q.add(i);
                }
            }
            farthest=Math.max(farthest,end);
        }
        return false;
    }
    public boolean canReach(String s, int minJump, int maxJump) {
        char arr[]=new char[s.length()];
        for(int i=0;i<arr.length;i++){
            arr[i]=s.charAt(i);
        }
        if(arr[0]!='0'||arr[arr.length-1]!='0'){
            return false;
        }
        return bfs(arr,0,minJump,maxJump);
    }
}