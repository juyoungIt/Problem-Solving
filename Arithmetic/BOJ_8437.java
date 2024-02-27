// BOJ - 8437
// Problem Sheet - https://www.acmicpc.net/problem/8437

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        BigInteger c = a.add(b).divide(BigInteger.valueOf(2));
        BigInteger d = a.subtract(b).divide(BigInteger.valueOf(2));

        System.out.printf("%s\n%s\n", c, d);

        br.close();
        System.exit(0);
    }
}