// PGS - 120839
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120839

class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<rsp.length(); i++) {
            char c = rsp.charAt(i);
            switch (c) {
                case '0':
                    sb.append(5);
                    break;
                case '2':
                    sb.append(0);
                    break;
                case '5':
                    sb.append(2);
                    break;
                default:
                    throw new IllegalArgumentException("invalid rsp character: " + c);
            }
        }
        return sb.toString();
    }
}
