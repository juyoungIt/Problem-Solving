// PGS - 120864
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120864

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int acc = 0;
        for (int i=0; i<my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (Character.isDigit(c)) {
                acc = acc * 10 + (c - '0');
            } else {
                answer += acc;
                acc = 0;
            }
        }
        return answer + acc;
    }
}
