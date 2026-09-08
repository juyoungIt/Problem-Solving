// PGS - 120904
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120904

class Solution {
    public int solution(int num, int k) {
        String str = Integer.toString(num);
        int len = str.length();
        char t = Integer.toString(k).charAt(0);
        for (int i=0; i<len; i++) {
            char c = str.charAt(i);
            if (c == t) {
                return i + 1;
            }
        }
        return -1;
    }
}
