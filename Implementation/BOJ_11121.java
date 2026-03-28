// BOJ - 11121
// Problem Sheet - https://www.acmicpc.net/problem/11121

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            sb.append(a.equals(b) ? "OK" : "ERROR").append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
