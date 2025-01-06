// BOJ - 13777
// Problem Sheet - https://www.acmicpc.net/problem/13777

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int target = Integer.parseInt(br.readLine());
            if (target == 0) break;
            int start = 1;
            int end = 50;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (mid == target) {
                    sb.append(mid).append(" ");
                    break;
                } else if (mid < target) {
                    sb.append(mid).append(" ");
                    start = mid + 1;
                } else {
                    sb.append(mid).append(" ");
                    end = mid - 1;
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}