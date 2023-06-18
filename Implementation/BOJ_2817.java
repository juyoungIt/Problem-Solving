// BOJ - 2840
// Problem Sheet - https://www.acmicpc.net/problem/2840

import java.util.*;
import java.io.*;

public class Main {

    static class Staff implements Comparable<Staff> {
        private final String name;
        private int numberOfChips;

        public Staff(String name) {
            this.name = name;
            this.numberOfChips = 0;
        }

        public String getName() {
            return this.name;
        }

        public void getChips() {
            this.numberOfChips++;
        }

        public String toString() {
            return name + " " + numberOfChips;
        }

        @Override
        public int compareTo(Staff staff) {
            return this.name.compareTo(staff.getName());
        }
    }

    static class Score implements Comparable<Score> {
        private final double score;
        private final Staff source;

        public Score(double score, Staff source) {
            this.score = score;
            this.source = source;
        }

        public double getScore() {
            return this.score;
        }

        public Staff getSource() {
            return this.source;
        }

        @Override
        public int compareTo(Score score) {
            return Double.compare(this.score, score.getScore()) * -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Score> scores = new PriorityQueue<>();
        PriorityQueue<Staff> staffs = new PriorityQueue<>();
        StringTokenizer st;

        int numberOfParticipants = Integer.parseInt(bf.readLine());
        int numberOfStaffs = Integer.parseInt(bf.readLine());
        Map<String, Staff> staffMapper = new HashMap<>();
        for(int i=0 ; i<numberOfStaffs ; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int votes = Integer.parseInt(st.nextToken());
            if((double)votes / numberOfParticipants >= 0.05) {
                staffMapper.put(name, new Staff(name));
                for(int j=1 ; j<=14 ; j++) {
                    scores.add(new Score((double)votes / j, staffMapper.get(name)));
                }
            }
        }

        for(int i=0 ; i<14 ; i++) {
            scores.poll().getSource().getChips();
        }

        staffs.addAll(staffMapper.values());
        while(!staffs.isEmpty()) {
            sb.append(staffs.poll().toString()).append("\n");
        }
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}