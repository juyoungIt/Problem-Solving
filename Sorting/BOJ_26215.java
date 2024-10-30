// BOJ - 26215
// Problem Sheet - https://www.acmicpc.net/problem/26215

import java.util.*;
import java.io.*;

public class Main {

    static class Home implements Comparable<Home> {
        private final int index;
        private int snow;

        public Home(int index, int snow) {
            this.index = index;
            this.snow = snow;
        }

        public int getIndex() { return this.index; }
        public int getSnow() { return this.snow; }
        public void removeSnow() { this.snow--; }

        @Override
        public int compareTo(Home h) {
            return h.getSnow() - this.snow;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Home> homes = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<N ; i++) {
            homes.add(new Home(i, Integer.parseInt(st.nextToken())));
        }

        int totalMinutes = 0;
        while (!homes.isEmpty()) {
            Home homeA = homes.poll();
            homeA.removeSnow();
            if (!homes.isEmpty()) {
                Home homeB = homes.poll();
                homeB.removeSnow();
                if (homeB.getSnow() > 0) {
                    homes.add(homeB);
                }
            }
            if (homeA.getSnow() > 0) {
                homes.add(homeA);
            }
            totalMinutes++;
        }

        System.out.println(totalMinutes > 1_440 ? -1 : totalMinutes);

        br.close();
    }
}