// BOJ - 2729
// Problem Sheet - https://www.acmicpc.net/problem/2729

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            BigInteger numberA = new BigInteger(st.nextToken(), 2);
            BigInteger numberB = new BigInteger(st.nextToken(), 2);
            sb.append(numberA.add(numberB).toString(2)).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}