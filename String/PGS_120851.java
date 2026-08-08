// PGS - 120851
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120851

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for (int i=0; i<my_string.length(); i++) {
            char cur = my_string.charAt(i);
            if (Character.isDigit(cur)) {
                answer += (int) (cur - '0');
            }
        }
        return answer;
    }
}
