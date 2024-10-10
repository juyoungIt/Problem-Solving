// BOJ - 2817
// Problem Sheet - https://www.acmicpc.net/problem/2817

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    static class Staff {
        private final char name;
        private final int recommended;
        private int chipCount;

        public Staff(char name, int recommended) {
            this.name = name;
            this.recommended = recommended;
            this.chipCount = 0;
        }

        public char getName() { return this.name; }
        public int getRecommended() { return this.recommended; }
        public void giveChip() { this.chipCount++; }

        @Override
        public String toString() {
            return this.name + " " + this.chipCount;
        }
    }

    static class Score implements Comparable<Score> {
        private final Staff staff;
        private final double value;

        public Score(Staff staff, double value) {
            this.staff = staff;
            this.value = value;
        }

        public Staff getStaff() { return this.staff; }
        public double getValue() { return this.value; }

        @Override
        public int compareTo(Score s) {
            return Double.compare(s.getValue(), this.value);
        }
    }

    private static int x;
    private static int n;

    public static void main(String[] args) throws IOException {
        List<Staff> staffs = getStaffsInfoFromInput().stream()
                .filter(s -> (double) s.getRecommended() / x >= 0.05)
                .collect(Collectors.toList());
        giveChipToStaffs(getScoreQueue(staffs));
        staffs.sort(Comparator.comparingInt(Staff::getName));
        System.out.println(getOutput(staffs));
    }

    private static List<Staff> getStaffsInfoFromInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        x = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        List<Staff> staffs = new ArrayList<>(n);
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            char name = st.nextToken().charAt(0);
            int recommended = Integer.parseInt(st.nextToken());
            staffs.add(new Staff(name, recommended));
        }

        br.close();
        return staffs;
    }

    private static PriorityQueue<Score> getScoreQueue(List<Staff> staffs) {
        PriorityQueue<Score> scores = new PriorityQueue<>();
        staffs.forEach(s -> {
            for (int i=1 ; i<=14 ; i++) {
                scores.add(new Score(s, (double) s.getRecommended() / i));
            }
        });
        return scores;
    }

    private static void giveChipToStaffs(PriorityQueue<Score> scoreQueue) {
        for (int i=0 ; i<14 ; i++) {
            scoreQueue.poll().getStaff().giveChip();
        }
    }

    private static String getOutput(List<Staff> staffs) {
        StringBuilder sb = new StringBuilder();
        staffs.forEach(s -> sb.append(s.toString()).append("\n"));
        return sb.toString();
    }
}