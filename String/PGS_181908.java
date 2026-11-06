// PGS - 181908
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181908

class Solution {
    public int solution(String my_string, String is_suffix) {
        int strLen = my_string.length();
        int suffixLen = is_suffix.length();
        if (strLen < suffixLen) return 0;
        int diff = strLen - suffixLen;
        for (int i=0; i<suffixLen; i++) {
            if (my_string.charAt(diff + i) != is_suffix.charAt(i)) {
                return 0;
            }
        }
        return 1;
    }
}
