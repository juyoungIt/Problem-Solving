// PGS - 120907
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120907

class Solution {
    public String[] solution(String[] quiz) {
        int len = quiz.length;
        String[] answer = new String[len];
        for (int i=0; i<len; i++) {
            String[] token = quiz[i].split(" ");
            int operand1 = Integer.parseInt(token[0]);
            char operator = token[1].charAt(0);
            int operand2 = Integer.parseInt(token[2]);
            int result =  Integer.parseInt(token[4]);
            if (operator == '+') {
                answer[i] = (operand1 + operand2 == result) ? "O" : "X";
            } else {
                answer[i] = (operand1 - operand2 == result) ? "O" : "X";
            }
        }
        return answer;
    }
}
