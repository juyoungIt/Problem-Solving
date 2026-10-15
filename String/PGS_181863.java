// PGS - 181863
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181863

class Solution {
    public String solution(String rny_string) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<rny_string.length(); i++) {
            char c = rny_string.charAt(i);
            sb.append(c == 'm' ? "rn" : c);
        }
        return sb.toString();
    }
}
