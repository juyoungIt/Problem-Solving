// BOJ - 13706
// Problem Sheet - https://www.acmicpc.net/problem/13706

import java.math.BigInteger;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n = new BigInteger(bf.readLine());
        BigInteger start = BigInteger.ONE;
        BigInteger end = n;
        BigInteger mid = BigInteger.ZERO;
        while(start.compareTo(end) <= 0) {
            mid = start.add(end).divide(BigInteger.TWO);
            if(mid.pow(2).equals(n)) {
                break;
            } else if(mid.pow(2).compareTo(n) < 0) {
                start = mid.add(BigInteger.ONE);
            } else {
                end = mid.subtract(BigInteger.ONE);
            }
        }

        System.out.println(mid);

        bf.close();
        System.exit(0);
    }
}