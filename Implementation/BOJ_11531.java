// BOJ - 11531
// Problem Sheet - https://www.acmicpc.net/problem/11531

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] a = new int[26];
        int cc = 0;
        int ts = 0;
        while (true) {
            String input = br.readLine();
            if (input.equals("-1")) break;
            st = new StringTokenizer(input);
            int m = Integer.parseInt(st.nextToken());
            char p = st.nextToken().charAt(0);
            String r = st.nextToken();
            if (r.equals("right")) {
                cc++;
                ts += (m + (20 * a[p - 'A']));
            } else {
                a[p - 'A']++;
            }
        }
        System.out.println(cc + " " + ts);
        br.close();
    }
}
