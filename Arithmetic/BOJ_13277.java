// BOJ - 13277
// Problem Sheet - https://www.acmicpc.net/problem/13277

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        BigInteger numberA = new BigInteger(st.nextToken());
        BigInteger numberB = new BigInteger(st.nextToken());
        System.out.println(numberA.multiply(numberB));

        bf.close();
        System.exit(0);
    }
}