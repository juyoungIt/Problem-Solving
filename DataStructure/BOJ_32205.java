// BOJ - 32205
// Problem Sheet - https://www.acmicpc.net/problem/32205

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] counts = new int[1_000_001];
        int N = Integer.parseInt(br.readLine());
        boolean isAvailable = false;
        while (N-- > 0) {
            String[] rect = br.readLine().split(" ");
            int a = Integer.parseInt(rect[0]);
            int b = Integer.parseInt(rect[1]);
            int c = Integer.parseInt(rect[2]);
            counts[a]++;
            counts[b]++;
            counts[c]++;
            if (counts[a] >= 2 || counts[b] >= 2 || counts[c] >= 2) {
                isAvailable = true;
                break;
            }
        }
        System.out.println(isAvailable ? 1 : 0);
        br.close();
    }
}
