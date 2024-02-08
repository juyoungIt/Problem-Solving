// BOJ - 26711
// Problem Sheet - https://www.acmicpc.net/problem/26711

import java.math.BigInteger;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger numberA = new BigInteger(br.readLine());
        BigInteger numberB = new BigInteger(br.readLine());

        System.out.println(numberA.add(numberB));

        br.close();
        System.exit(0);
    }
}