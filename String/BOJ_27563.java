// BOJ - 27563
// Problem Sheet - https://www.acmicpc.net/problem/27563

import java.io.*;

public class Main {

    static final int IMPOSSIBLE = 101;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            String s = br.readLine();
            int oc = IMPOSSIBLE;
            for (int i=0 ; i<=s.length()-3 ; i++) {
                if (s.charAt(i + 1) == 'O') {
                    int tmp = 0;
                    if (s.charAt(i) != 'M') tmp++;
                    if (s.charAt(i + 2) != 'O') tmp++;
                    oc = Math.min(oc, tmp);
                }
            }
            if (oc == IMPOSSIBLE) sb.append(-1).append("\n");
            else sb.append(oc + s.length() - 3).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

}