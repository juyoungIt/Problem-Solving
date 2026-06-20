// PGS - 12926
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12926

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i=0; i<len; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(c);
                continue;
            }
            if (Character.isLowerCase(c)) {
                int p = ((c - 'a') + n) % 26;
                sb.append((char)('a' + p));
            } else {
                int p = ((c - 'A') + n) % 26;
                sb.append((char)('A' + p));
            }
        }
        return sb.toString();
    }
}
