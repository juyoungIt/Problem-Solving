// BOJ - 2935
// Problem Sheet - https://www.acmicpc.net/problem/2935

import java.math.BigInteger;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        BigInteger operandA = new BigInteger(bf.readLine());
        char operator = bf.readLine().charAt(0);
        BigInteger operandB = new BigInteger(bf.readLine());

        if(operator == '+') {
            System.out.println(operandA.add(operandB));
        } else if(operator == '*') {
            System.out.println(operandA.multiply(operandB));
        } else {
            throw new IllegalArgumentException();
        }

        bf.close();
        System.exit(0);
    }
}