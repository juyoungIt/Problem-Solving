// BOJ - 6495
// Problem Sheet - https://www.acmicpc.net/problem/6495

import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {

    private static final String CORRECT_MESSAGE = "Guess #%d was correct.\n";
    private static final String INCORRECT_MESSAGE = "Guess #%d was incorrect.\n";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, BigDecimal> percentageMapper = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        String[] numberInfos = bf.readLine().split(" ");
        int numberOfInformation = Integer.parseInt(numberInfos[0]);
        int numberOfGuesses = Integer.parseInt(numberInfos[1]);

        for(int i=0 ; i<numberOfInformation ; i++) {
            String[] percentageInformation = bf.readLine().split(" ");
            percentageMapper.put(percentageInformation[0], new BigDecimal(percentageInformation[1]));
        }

        for(int i=1 ; i<=numberOfGuesses ; i++) {
            String[] guessTokens = bf.readLine().split(" ");
            BigDecimal operand1 = new BigDecimal(0);
            int operand2 = 0;
            String comparator = "";
            for(String guessToken : guessTokens) {
                if(isComparator(guessToken)) {
                    comparator = guessToken;
                    operand2 = Integer.parseInt(guessTokens[guessTokens.length-1]);
                    break;
                }
                if(!guessToken.equals("+")) {
                    operand1 = operand1.add(percentageMapper.get(guessToken));
                }
            }
            if(validation(operand1, operand2, comparator)) {
                sb.append(String.format(CORRECT_MESSAGE, i));
            } else {
                sb.append(String.format(INCORRECT_MESSAGE, i));
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static boolean isComparator(String operator) {
        return operator.equals("<")
                || operator.equals("<=")
                || operator.equals(">")
                || operator.equals(">=")
                || operator.equals("=");
    }

    private static boolean validation(BigDecimal operand1, int operand2, String comparator) {
        switch (comparator) {
            case "<": return operand1.compareTo(new BigDecimal(operand2)) < 0;
            case "<=": return operand1.compareTo(new BigDecimal(operand2)) <= 0;
            case ">": return operand1.compareTo(new BigDecimal(operand2)) > 0;
            case ">=": return operand1.compareTo(new BigDecimal(operand2)) >= 0;
            case "=": return operand1.compareTo(new BigDecimal(operand2)) == 0;
            default: throw new IllegalArgumentException();
        }
    }
}