// BOJ - 19598
// Problem Sheet - https://www.acmicpc.net/problem/19598

import java.util.*;
import java.io.*;

public class Main {

    static class Meeting implements Comparable<Meeting> {
        private final int start;
        private final int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() { return this.start; }
        public int getEnd() { return this.end; }

        @Override
        public int compareTo(Meeting m) {
            return this.start - m.getStart();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Meeting> meetings = new ArrayList<>(N);
        for (int i=0 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }
        Collections.sort(meetings);

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        for (Meeting meeting : meetings) {
            if (!endTimes.isEmpty() && endTimes.peek() <= meeting.getStart()) {
                endTimes.poll();
            }
            endTimes.add(meeting.getEnd());
        }
        System.out.println(endTimes.size());

        br.close();
    }
}