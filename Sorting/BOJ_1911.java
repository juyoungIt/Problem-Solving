// BOJ - 1911
// Problem Sheet - https://www.acmicpc.net/problem/1911

import java.util.*;
import java.io.*;

public class Main {

    static class Pool {
        private final int start;
        private final int end;

        public Pool(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() { return this.start; }
        public int getEnd() { return this.end; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Pool[] pools = new Pool[N];
        for (int i=0 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pools[i] = new Pool(start, end);
        }
        Arrays.sort(pools, Comparator.comparingInt(Pool::getStart));

        int boardCount = 0;
        int remain;
        int lastEnd = 0;
        for (Pool pool : pools) {
            int start = pool.getStart();
            int end = pool.getEnd();
            remain = Math.max(0, lastEnd - start);
            boardCount += Math.max(0, (end - start - remain) / L);
            if ((end - start - remain) % L > 0) {
                boardCount++;
                remain = L - ((end - start - remain) % L);
            } else {
                remain = 0;
            }
            lastEnd = Math.max(end + remain, lastEnd);
        }
        System.out.println(boardCount);

        br.close();
    }
}