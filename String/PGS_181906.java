// PGS - 181906
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181906

class Solution {
    public int solution(String my_string, String is_prefix) {
        int strLen = my_string.length();
        int prefixLen = is_prefix.length();
        if (strLen < prefixLen) {
            return 0;
        }
        for (int i=0; i<prefixLen; i++) {
            char c1 = my_string.charAt(i);
            char c2 = is_prefix.charAt(i);
            if (c1 != c2) {
                return 0;
            }
        }
        return 1;
    }
}
