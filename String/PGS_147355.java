// PGS - 147355
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/147355

class Solution {
    public int solution(String t, String p) {
        int lenT = t.length(), lenP = p.length();
        int answer = 0;
        for (int i=0; i<=lenT-lenP; i++) {
            if (t.substring(i, i + lenP).compareTo(p) <= 0) {
                answer++;
            }
        }
        return answer;
    }
}
