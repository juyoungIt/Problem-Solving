// PGS - 181931
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181931

class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for (int i=0; i<included.length; i++) {
            if (included[i]) {
                answer += a + d * i;
            }
        }
        return answer;
    }
}
