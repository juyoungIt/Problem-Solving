// BOJ - 1941
// Problem Sheet - https://www.acmicpc.net/problem/1941

import java.io.*;

public class Main {

    private static boolean[] visited;
    private static final char[] students = new char[25];
    private static final int[] buffer = new int[7];

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve(0, 0));
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0 ; i<5 ; i++) {
            char[] row = br.readLine().toCharArray();
            System.arraycopy(row, 0, students, i * 5, 5);
        }
        br.close();
    }

    private static int solve(int count, int lastValue) {
        int validCount = 0;
        if (count == 7) {
            if (isValid()) validCount++;
        } else {
            for (int i=lastValue ; i<25 ; i++) {
                buffer[count] = i;
                validCount += solve(count + 1, i + 1);
            }
        }
        return validCount;
    }

    private static boolean isValid() {
        visited = new boolean[25];
        return dfs(0) == 7 && isValidCounts();
    }

    private static boolean isConnected(int a, int b) {
        int diff = Math.abs(a - b);
        int max = Math.max(a, b);
        if (diff == 5) return true;
        if (diff == 1 && max % 5 != 0) return true;
        return false;
    }

    private static int dfs(int sn) {
        int count = 0;
        visited[sn] = true;
        count++;
        for (int i=1 ; i<7 ; i++) {
            int a = buffer[sn];
            int b = buffer[i];
            if (visited[i] || !isConnected(a, b)) continue;
            count += dfs(i);
        }
        return count;
    }

    private static boolean isValidCounts() {
        int count = 0;
        for (int i=0 ; i<7 ; i++) {
            if (students[buffer[i]] == 'S') {
                count++;
            }
        }
        return count >= 4;
    }
}