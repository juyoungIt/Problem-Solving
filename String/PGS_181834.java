// PGS - 181834
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181834

class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<myString.length(); i++) {
            char c = myString.charAt(i);
            sb.append(c < 'l' ? 'l' : c);
        }
        return sb.toString();
    }
}
