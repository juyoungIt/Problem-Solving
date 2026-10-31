// PGS - 120863
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120863

class Solution {
    public String solution(String polynomial) {
        String[] tokens = polynomial.split(" \\+ ");
        int[] values = new int[2];
        for (String token : tokens) {
            if (token.charAt(token.length() - 1) == 'x') {
                if (token.length() == 1) {
                    values[0]++;
                    continue;
                }
                values[0] += Integer.parseInt(token.substring(0, token.length() - 1));
            } else {
                values[1] += Integer.parseInt(token);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (values[0] > 0) {
            if (values[0] > 1) sb.append(values[0]);
            sb.append("x");
        }
        if (values[1] > 0) {
            if (values[0] > 0) sb.append(" + ");
            sb.append(values[1]);
        }
        return sb.toString();
    }
}
