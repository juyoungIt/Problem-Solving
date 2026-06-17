// PGS - 12932
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12932

class Solution {
    public int[] solution(long n) {
        String s = Long.toString(n);
        int len = s.length();
        int[] answer = new int[len];
        for (int i=0; i<len; i++) {
            answer[len - i - 1] = s.charAt(i) - '0';
        }
        return answer;
    }
}
