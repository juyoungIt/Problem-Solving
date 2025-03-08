// BOJ - 1963
// Problem Sheet - https://www.acmicpc.net/problem/1963

import java.util.*;
import java.io.*;

public class Main {

    static class Status {
        private final int value;
        private final int convertCount;

        public Status(int value, int convertCount) {
            this.value = value;
            this.convertCount = convertCount;
        }

        public int getValue() { return this.value; }
        public int getConvertCount() { return this.convertCount; }
    }

    private static int A, B;
    private static final String IMPOSSIBLE = "Impossible";
    private static final boolean[] isNotPrimeNumber = new boolean[10_000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        isNotPrimeNumber[0] = true;
        isNotPrimeNumber[1] = true;
        for (int i=2 ; i<10_000; i++) {
            if (isNotPrimeNumber[i]) continue;
            for (int j=i+i ; j<10_000 ; j+=i) {
                isNotPrimeNumber[j] = true;
            }
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] row = br.readLine().split(" ");
            A = Integer.parseInt(row[0]);
            B = Integer.parseInt(row[1]);
            int convertCount = bfs();
            sb.append(convertCount >= 0 ? convertCount : IMPOSSIBLE).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int bfs() {
        int convertCount = -1;
        Queue<Status> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[10_000];
        queue.add(new Status(A, 0));
        visited[A] = true;
        while (!queue.isEmpty()) {
            Status cur = queue.poll();
            if (cur.getValue() == B) {
                convertCount = cur.getConvertCount();
                break;
            }
            for (int i=0 ; i<4 ; i++) {
                for (int j=0 ; j<10 ; j++) {
                    int nextValue = getNextValue(cur.getValue(), i, j);
                    if (isOutOfRange(nextValue) || visited[nextValue] || isNotPrimeNumber[nextValue]) continue;
                    queue.add(new Status(nextValue, cur.getConvertCount() + 1));
                    visited[nextValue] = true;
                }
            }
        }
        return convertCount;
    }

    private static int getNextValue(int origin, int changeIndex, int value) {
        int[] digits = new int[4];
        digits[0] = origin / 1_000;
        digits[1] = (origin % 1_000) / 100;
        digits[2] = (origin % 100) / 10;
        digits[3] = origin % 10;
        digits[changeIndex] = value;
        return digits[0] * 1_000 + digits[1] * 100 + digits[2] * 10 + digits[3];
    }

    private static boolean isOutOfRange(int n) {
        return !(1_000 <= n && n < 10_000);
    }
}