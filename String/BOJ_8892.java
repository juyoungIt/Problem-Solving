// BOJ - 8892
// Problem Sheet - https://www.acmicpc.net/problem/8892

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String[] words = new String[k];
            for (int i=0 ; i<k ; i++) {
                words[i] = br.readLine();
            }
            boolean isAvailable = false;
            for (int i=0 ; i<k ; i++) {
                for (int j=0 ; j<k ; j++) {
                    if (i == j) continue;
                    if (mergeIsPalindrome(words[i], words[j])) {
                        sb.append(words[i]).append(words[j]).append("\n");
                        isAvailable = true;
                        break;
                    }
                }
                if (isAvailable) break;
            }
            if (!isAvailable) sb.append(0).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean mergeIsPalindrome(String a, String b) {
        String merged = a + b;
        int left = 0, right = a.length() + b.length() - 1;
        while (left < right) {
            if (merged.charAt(left++) != merged.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}