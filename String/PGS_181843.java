// PGS - 181843
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181843

class Solution {
    public int solution(String my_string, String target) {
        int len = my_string.length() - target.length();
        for (int i=0; i<=len; i++) {
            if (target.equals(my_string.substring(i, i + target.length()))) {
                return 1;
            }
        }
        return 0;
    }
}
