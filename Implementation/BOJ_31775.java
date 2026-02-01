// BOJ - 31775
// Problem Sheet - https://www.acmicpc.net/problem/31775

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = new String[3];
        for (int i=0 ; i<3 ; i++) {
            s[i] = br.readLine();
        }
        boolean l = false, k = false, p = false;
        for (int i=0 ; i<3 ; i++) {
            if (s[i].charAt(0) == 'l') {
                l = true;
            } else if (s[i].charAt(0) == 'k') {
                k = true;
            } else if (s[i].charAt(0) == 'p') {
                p = true;
            }
        }
        System.out.println((l && k && p) ? "GLOBAL" : "PONIX");
        br.close();
    }
}
