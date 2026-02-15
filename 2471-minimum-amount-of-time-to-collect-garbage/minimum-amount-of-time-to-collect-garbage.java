class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
    int sum = 0, count = 0; 
    Map<Character, Integer> last= new HashMap<>();
    for(int i = 0; i < garbage.length; ++i){
        count += garbage[i].length();
        for(char c: garbage[i].toCharArray()) last.put(c, sum);
        if(i < travel.length) sum += travel[i];
    }
    return count + last.getOrDefault('M', 0) + last.getOrDefault('P', 0) + last.getOrDefault('G', 0);
}
}