class Solution {
    public static List<String> problem(List<String> list,int n1,int n2,String s){
        if(n1==0&&n2==0){
         list.add(s);
         return list;
        }
        if(n1>0){
        problem(list,n1-1,n2,s+'(');
        }
        if(n1<n2){
        problem(list,n1,n2-1,s+')');
        }
        return list;
    } 
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        return problem(list,n,n,"");
    }
}