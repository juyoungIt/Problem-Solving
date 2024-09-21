// BOJ - 5939
// Problem Sheet - https://www.acmicpc.net/problem/5939

import java.util.*;
import java.io.*;

public class Main {

    static class Time implements Comparable<Time> {
        private final int hour;
        private final int minute;
        private final int second;

        public Time(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        public int getHour() { return this.hour; }
        public int getMinute() { return this.minute; }
        public int getSecond() { return this.second; }

        @Override
        public int compareTo(Time t) {
            if (this.hour == t.getHour()) {
                if (this.minute == t.getMinute()) {
                    return this.second - t.getSecond();
                }
                return this.minute - t.getMinute();
            }
            return this.hour - t.getHour();
        }

        @Override
        public String toString() {
            return this.hour + " " + this.minute + " " + this.second;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Time> times = new ArrayList<>();
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            times.add(new Time(hour, minute, second));
        }
        Collections.sort(times);

        for (Time time : times) {
            sb.append(time.toString()).append("\n");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}