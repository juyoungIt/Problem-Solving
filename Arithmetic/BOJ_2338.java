// BOJ - 2338
// Problem Sheet - https://www.acmicpc.net/problem/2338

import java.math.BigInteger;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BigInteger numberA = new BigInteger(bf.readLine());
        BigInteger numberB = new BigInteger(bf.readLine());

        System.out.println(numberA.add(numberB));
        System.out.println(numberA.subtract(numberB));
        System.out.println(numberA.multiply(numberB));

        bf.close();
        System.exit(0);
    }
}