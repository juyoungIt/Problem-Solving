// BOJ - 1247
// Problem Sheet - https://www.acmicpc.net/problem/1247

import java.math.BigInteger;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<3 ; i++) {
            int N = Integer.parseInt(bf.readLine());
            BigInteger sum = new BigInteger("0");
            for(int j=0 ; j<N ; j++) {
                sum = sum.add(new BigInteger(bf.readLine()));
            }
            if(sum.compareTo(new BigInteger("0")) == 0) {
                sb.append("0");
            } else if(sum.compareTo(new BigInteger("0")) > 0) {
                sb.append("+");
            } else {
                sb.append("-");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}