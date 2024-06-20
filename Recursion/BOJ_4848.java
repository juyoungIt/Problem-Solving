// BOJ - 4848
// Problem Sheet - https://www.acmicpc.net/problem/4848

import java.util.*;
import java.io.*;

public class Main {

    private static StringJoiner sj = new StringJoiner(",", "{", "}");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            String operandA = br.readLine();
            String operandB = br.readLine();
            sb.append(addSetNumber(operandA, operandB)).append("\n");
            sj = new StringJoiner(",", "{", "}");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static String addSetNumber(String operandA, String operandB) {
        return valueToSetNumber(setNumberToValue(operandA) + setNumberToValue(operandB));
    }

    private static int setNumberToValue(String setNumber) {
        if (setNumber.equals("{}")) {
            return 0;
        } else {
            Set<String> elements = new HashSet<>(Arrays.asList(setNumber.split(",")));
            return elements.size();
        }
    }

    private static String valueToSetNumber(int number) {
        if (number == 0) {
            return sj.toString();
        } else {
            return sj.add(valueToSetNumber(number-1)).toString();
        }
    }
}