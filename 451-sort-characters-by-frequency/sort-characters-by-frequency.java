class Solution {
    public String frequencySort(String s) {
        int freq[]=new int[128];
        for(char ch:s.toCharArray()){
            freq[ch]++;
        }
        Character[] chars=new Character[s.length()];
        for(int i=0;i<s.length();i++){
            chars[i]=s.charAt(i);
        }
        Arrays.sort(chars,(a,b)->{
            if(freq[a]==freq[b]){
                return Character.compare(a,b);
            }
            return Integer.compare(freq[b],freq[a]);
        });

        StringBuilder sb=new StringBuilder();
        for(char ch:chars){
            sb.append(ch);
        }
        return sb.toString();
    }
}