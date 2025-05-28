// BOJ - 29301
// Problem Sheet - https://www.acmicpc.net/problem/29301

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] h = new int[n + 1];
        long[] accH = new long[n + 1];
        int curIndex = 1;
        for (int i=0 ; i<n ; i++) {
            String cmd = br.readLine();
            char type = cmd.charAt(0);
            if (type == '+') {
                int value = Integer.parseInt(cmd.substring(1));
                h[curIndex] = value;
                accH[curIndex] = accH[curIndex - 1] + value;
                curIndex++;
            } else if (type == '-') {
                sb.append(h[--curIndex]).append("\n");
            } else if (type == '?') {
                int size = Integer.parseInt(cmd.substring(1));
                sb.append(accH[curIndex - 1] - accH[curIndex - 1 - size]).append("\n");
            } else {
                throw new IOException("invalid command...");
            }
        }

        System.out.println(sb);
        br.close();
    }
}