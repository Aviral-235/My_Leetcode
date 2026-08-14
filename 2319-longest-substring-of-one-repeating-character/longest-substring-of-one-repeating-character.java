class Solution {
    class Node{
        int prefixLen,suffixLen,best;
        char leftChar,rightChar;
    }
    Node[] tree;
    char[] S;
    int n;
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        S=s.toCharArray();
        n=s.length();
        tree=new Node[n*4];
        build(1,0,n-1);
        char query[]=queryCharacters.toCharArray();
        int ans[]=new int[queryIndices.length];
        for(int i=0;i<queryIndices.length;i++){
            update(1,0,n-1,queryIndices[i],query[i]);
            ans[i]=tree[1].best;

        }
        return ans;
    }

    public void build(int node,int l,int r){
        if(l==r){
            Node leaf=new Node();
            leaf.prefixLen=1;
            leaf.suffixLen=1;
            leaf.best=1;
            leaf.leftChar=S[l];
            leaf.rightChar=S[l];
            tree[node]=leaf;
            return;
        }
        int mid=(l+r)/2;
        build(2*node,l,mid);
        build(2*node+1,mid+1,r);
        tree[node]=merge(tree[2*node],tree[2*node+1],mid-l+1,r-mid);

    }
    public void update(int node,int l,int r,int idx,char c){
        if(l==r){
            S[idx]=c;
            tree[node].leftChar=c;
            tree[node].rightChar=c;
            return;
        }
        int mid=(l+r)/2;
        if(idx<=mid){
            update(2*node,l,mid,idx,c);
        }
        else{
            update(2*node+1,mid+1,r,idx,c);
        }
        tree[node]=merge(tree[2*node],tree[2*node+1],mid-l+1,r-mid);
    }
    Node merge(Node left,Node right,int leftSize,int rightSize){
        Node res=new Node();
        res.leftChar=left.leftChar;
        res.rightChar=right.rightChar;
        res.best=Math.max(left.best,right.best);
        res.prefixLen=left.prefixLen;
        res.suffixLen=right.suffixLen;
        if(left.rightChar==right.leftChar){
            res.best=Math.max(res.best,left.suffixLen+right.prefixLen);
             if(left.prefixLen==leftSize){
            res.prefixLen=left.prefixLen+right.prefixLen;
        }
        if(right.suffixLen==rightSize){
            res.suffixLen=left.suffixLen+right.suffixLen;
        }
        }

       
        return res;
    }
}