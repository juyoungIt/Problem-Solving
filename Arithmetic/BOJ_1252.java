// BOJ - 1252
// Problem Sheet - https://www.acmicpc.net/problem/1252

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        BigInteger numberA = new BigInteger(st.nextToken(), 2);
        BigInteger numberB = new BigInteger(st.nextToken(), 2);

        System.out.println(numberA.add(numberB).toString(2));

        bf.close();
        System.exit(0);
    }
}