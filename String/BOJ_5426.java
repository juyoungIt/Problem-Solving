// BOJ - 5426
// Problem Sheet - https://www.acmicpc.net/problem/5426

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String before = br.readLine();
            int size = (int) Math.sqrt(before.length());
            char[][] box = new char[size][size];
            for (int i=0 ; i<size ; i++) {
                for (int j=0 ; j<size ; j++) {
                    box[i][j] = before.charAt(i * size + j);
                }
            }
            for (int i=size-1 ; i>=0 ; i--) {
                for (int j=0 ; j<size ; j++) {
                    sb.append(box[j][i]);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}