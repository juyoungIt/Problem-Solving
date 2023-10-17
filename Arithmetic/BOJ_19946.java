// BOJ - 19946
// Problem Sheet - https://www.acmicpc.net/problem/19946

import java.math.BigInteger;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(bf.readLine());

        int breakPoint = 64;
        for(int i=64 ; i>=0 ; i--) {
            if(!n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                breakPoint = i;
                break;
            }
            n = n.divide(BigInteger.TWO);
        }

        System.out.println(breakPoint);

        bf.close();
        System.exit(0);
    }
}