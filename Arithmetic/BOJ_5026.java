// BOJ - 5026
// Problem Sheet - https://www.acmicpc.net/problem/5026

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i=0 ; i<n ; i++) {
            String[] tokens = br.readLine().split("\\+");
            if(tokens.length == 2) {
                sb.append(Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]));
            } else {
                sb.append("skipped");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}