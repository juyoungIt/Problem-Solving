// PGS - 181932
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181932

class Solution {
    public String solution(String code) {
        StringBuilder ret = new StringBuilder();
        int mode = 0;
        for (int i=0; i<code.length(); i++) {
            char c = code.charAt(i);
            if (mode == 0) {
                if (c == '1') {
                    mode = 1;
                    continue;
                }
                if (i % 2 == 0) {
                    ret.append(c);
                }
            } else {
                if (c == '1') {
                    mode = 0;
                    continue;
                }
                if (i % 2 != 0) {
                    ret.append(c);
                }
            }
        }
        return ret.length() > 0 ? ret.toString() : "EMPTY";
    }
}
