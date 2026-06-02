// PGS - 155652
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/155652

class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] ignore = new boolean[26];
        for (int i=0; i<skip.length(); i++) {
            ignore[skip.charAt(i) - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            sb.append(slide(s.charAt(i), index, ignore));
        }
        return sb.toString();
    }
    
    private char slide(char c, int index, boolean[] ignore) {
        int curIndex = c - 'a';
        while (index > 0) {
            curIndex = (curIndex + 1) % 26;
            if (ignore[curIndex]) continue;
            index--;
        }
        return (char) ('a' + curIndex);
    }
}
