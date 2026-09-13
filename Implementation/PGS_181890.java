// PGS - 181890
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181890

class Solution {
    public String[] solution(String[] str_list) {
        int len = str_list.length;
        for (int i=0; i<len; i++) {
            char c = str_list[i].charAt(0);
            if (c == 'l') {
                String[] answer = new String[i];
                System.arraycopy(str_list, 0, answer, 0, i);
                return answer;
            } else if (c == 'r') {
                String[] answer = new String[len - i - 1];
                System.arraycopy(str_list, i + 1, answer, 0, len - i - 1);
                return answer;
            }
        }
        return new String[0];
    }
}
