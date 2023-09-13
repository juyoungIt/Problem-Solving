// BOJ - 2702
// Problem Sheet - https://www.acmicpc.net/problem/2702

import java.util .*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<T ; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int gcd = getGCD(a, b);
            int lcm = getLCM(a, b, gcd);
            sb.append(lcm).append(" ").append(gcd).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int getGCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    private static int getLCM(int a, int b, int gcd) {
        return a * b / gcd;
    }
}