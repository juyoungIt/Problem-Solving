// PGS - 181872
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181872

class Solution {
    public String solution(String myString, String pat) {
        int patLen = pat.length();
        int curIndex = myString.length() - patLen;
        String answer = null;
        while (curIndex >= 0) {
            if (myString.substring(curIndex, curIndex + patLen).equals(pat)) {
                answer = myString.substring(0, curIndex + patLen);
                break;
            }
            curIndex--;
        }
        return answer;
    }
}
