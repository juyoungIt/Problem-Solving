// BOJ - 16472
// Problem Sheet - https://www.acmicpc.net/problem/16472

import java.io.*;

public class Main {

    private static int N;
    private static String str;

    public static void main(String[] args) throws IOException {
        getInput();
        System.out.println(solve());
    }

    private static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        br.close();
    }

    private static int solve() {
        int[] usedCounts = new int[26];
        int left = 0, right = 0;
        int curLength = 1, maxLength = 0;

        usedCounts[str.charAt(0) - 'a']++;
        while (right < str.length()) {
            int usedCount = getUsedCount(usedCounts);
            if (usedCount <= N) {
                maxLength = Math.max(maxLength, curLength);
                if (right + 1 >= str.length()) {
                    break;
                }
                usedCounts[str.charAt(++right) - 'a']++;
                curLength++;
            } else {
                usedCounts[str.charAt(left++) - 'a']--;
                curLength--;
            }
        }

        return maxLength;
    }

    private static int getUsedCount(int[] usedCounts) {
        int count = 0;
        for (int usedCount : usedCounts) {
            if (usedCount > 0) {
                count++;
            }
        }
        return count;
    }
}