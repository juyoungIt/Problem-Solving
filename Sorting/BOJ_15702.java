// BOJ - 15702
// Problem Sheet - https://www.acmicpc.net/problem/15702

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    static class Student implements Comparable<Student> {
        private final int number;
        private final int score;

        public Student(int number, int score) {
            this.number = number;
            this.score = score;
        }

        public int getNumber() { return this.number; }
        public int getScore() { return this.score; }


        @Override
        public int compareTo(Student s) {
            if (this.score == s.getScore()) {
                return this.number - s.getNumber();
            }
            return s.getScore() - this.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] points = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Map<Integer, Integer> scores = new HashMap<>();
        for (int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            for (int j=0 ; j<n ; j++) {
                String result = st.nextToken();
                scores.put(number, scores.getOrDefault(number, 0) + (result.equals("O") ? points[j] : 0));
            }
        }

        List<Student> students = scores.entrySet()
                .stream()
                .map(e -> new Student(e.getKey(), e.getValue()))
                .sorted()
                .collect(Collectors.toList());

        System.out.printf(
                "%d %d\n",
                students.get(0).getNumber(),
                students.get(0).getScore()
        );

        br.close();
        System.exit(0);
    }
}