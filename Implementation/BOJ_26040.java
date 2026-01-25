// BOJ - 26040
// Problem Sheet - https://www.acmicpc.net/problem/26040

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String a = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] alpha = new boolean[26];
        while (st.hasMoreTokens()) {
            char b = st.nextToken().charAt(0);
            alpha[b - 'A'] = true;
        }
        for (int i=0 ; i<a.length() ; i++) {
            if (Character.isUpperCase(a.charAt(i)) && alpha[a.charAt(i) - 'A']) {
                sb.append(Character.toLowerCase(a.charAt(i)));
            } else {
                sb.append(a.charAt(i));
            }
        }
        System.out.println(sb);
        br.close();
    }
}
