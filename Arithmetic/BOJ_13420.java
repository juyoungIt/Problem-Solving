// BOJ - 13420
// Problem Sheet - https://www.acmicpc.net/problem/13420

import java.io.*;

public class Main {

    private static final String CORRECT = "correct";
    private static final String INCORRECT = "wrong answer";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<t ; i++) {
            String[] operands = bf.readLine().split(" = ");
            if(getValue(operands[0]) == getValue(operands[1])) {
                sb.append(CORRECT).append("\n");
            } else {
                sb.append(INCORRECT).append("\n");
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static long getValue(String str) {
        String[] operands = str.split(" ");
        if(operands.length > 1) {
            long a = Long.parseLong(operands[0]);
            long b = Long.parseLong(operands[2]);
            if(operands[1].charAt(0) == '+') {
                return a + b;
            } else if(operands[1].charAt(0) == '-') {
                return a - b;
            } else if(operands[1].charAt(0) == '*') {
                return a * b;
            } else {
                return a / b;
            }
        }
        return Long.parseLong(operands[0]);
    }
}