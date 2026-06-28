// PGS - 140108
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/140108

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        int curIndex = 0;
        while (curIndex < len) {
            char x = s.charAt(curIndex);
            int countX = 1, countNotX = 0;
            curIndex++;
            while (countX != countNotX && curIndex < len) {
                char c = s.charAt(curIndex);
                if (c == x) countX++;
                else countNotX++;
                curIndex++;
            }
            answer++;
        }
        return answer;
    }
}
