class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == ch) {
                String str = word.substring(0, i + 1);
                sb.append(str).reverse();
                String rest = word.substring(i + 1);
                sb.append(rest);
                break;
            }
        }
        if(sb.toString() == "") sb.append(word);
        return sb.toString();
    }
}