// BOJ - 11008
// Problem Sheet - https://www.acmicpc.net/problem/11008

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] row = br.readLine().split(" ");
            String s = row[0];
            String p = row[1];
            String result = s.replaceAll(p, " ");
            sb.append(result.length()).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}