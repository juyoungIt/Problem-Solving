// PGS - 120908
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120908

class Solution {
    public int solution(String str1, String str2) {
        int str1Len = str1.length();
        int str2Len = str2.length();
        for (int i=0; i<=str1Len-str2Len; i++) {
            String sub = str1.substring(i, i + str2Len);
            if (str2.equals(sub)) {
                return 1;
            }
        }
        return 2;
    }
}
