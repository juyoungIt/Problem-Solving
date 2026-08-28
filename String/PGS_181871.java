// PGS - 181871
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181871

class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int patLen = pat.length();
        for (int i=0; i<=myString.length()-patLen; i++) {
            if (myString.substring(i, i + patLen).equals(pat)) {
                answer++;
            }
        }
        return answer;
    }
}
