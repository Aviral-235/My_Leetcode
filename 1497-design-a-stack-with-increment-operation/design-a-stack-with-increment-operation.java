class CustomStack{
    int[]arr;
    int[]inc;
    int size;
    public CustomStack(int maxSize){
        arr=new int[maxSize];
        inc=new int[maxSize];
        size=0;
    }
    public void push(int x){
        if(size<arr.length){
            arr[size]=x;
            inc[size]=0;
            size++;
        }
    }
    public int pop(){
        if(size<=0)return -1;
        size--;
        int res=arr[size]+inc[size];
        if(size>0)inc[size-1]+=inc[size];
        inc[size]=0;
        return res;
    }
    public void increment(int k,int val){
        int idx=Math.min(k,size)-1;
        if(idx>=0)inc[idx]+=val;
    }
}
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */