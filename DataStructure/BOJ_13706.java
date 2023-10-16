// BOJ - 13706
// Problem Sheet - https://www.acmicpc.net/problem/13706

import java.math.BigInteger;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n = new BigInteger(bf.readLine());
        System.out.println(n.sqrt());

        bf.close();
        System.exit(0);
    }
}