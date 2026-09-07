// PGS - 120913
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120913

class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length();
        int size = len / n + ((len % n == 0) ? 0 : 1);
        String[] answer = new String[size];
        int index = 0;
        for (int i=0; i<len; i+=n) {
            answer[index++] = my_str.substring(i, Math.min(i + n, len));
        }
        return answer;
    }
}
