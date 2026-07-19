// PGS - 181878
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181878

class Solution {
    public int solution(String myString, String pat) {
        myString = myString.toLowerCase();
        pat = pat.toLowerCase();
        return myString.contains(pat) ? 1 : 0;
    }
}
