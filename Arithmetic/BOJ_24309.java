// BOJ - 24309
// Problem Sheet - https://www.acmicpc.net/problem/24309

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        BigInteger c = new BigInteger(br.readLine());

        System.out.println((b.subtract(c)).divide(a));

        br.close();
        System.exit(0);
    }
}