// BOJ - 1271
// Problem Sheet - https://www.acmicpc.net/problem/1271

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        BigInteger property = new BigInteger(st.nextToken());
        BigInteger numberOfCreatures = new BigInteger(st.nextToken());

        System.out.println(property.divide(numberOfCreatures));
        System.out.println(property.mod(numberOfCreatures));

        bf.close();
        System.exit(0);
    }
}