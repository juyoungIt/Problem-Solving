// BOJ - 20949
// Problem Sheet - https://www.acmicpc.net/problem/20949

import java.util.*;
import java.io.*;

public class Main {

    private static final int INCH = 77;

    static class Monitor implements Comparable<Monitor> {
        private final int number;
        private final int width;
        private final int height;

        public Monitor(int number, int width, int height) {
            this.number = number;
            this.width = width;
            this.height = height;
        }

        private double getPPI() {
            return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2)) / INCH;
        }

        public int getNumber() { return this.number; }

        @Override
        public int compareTo(Monitor m) {
            return Double.compare(m.getPPI(), getPPI());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Monitor> monitors = new ArrayList<>(N);
        for (int i=1 ; i<=N ; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            monitors.add(new Monitor(i, W, H));
        }
        Collections.sort(monitors);

        for (Monitor monitor : monitors) {
            sb.append(monitor.getNumber()).append("\n");
        }
        System.out.println(sb);

        br.readLine();
    }
}