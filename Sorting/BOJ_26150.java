// BOJ - 26150
// Problem Sheet - https://www.acmicpc.net/problem/26150

import java.util.*;
import java.io.*;

public class Main {

    static class Problem implements Comparable<Problem> {
        private final String title;
        private final int index;
        private final int difficulty;

        public Problem(String title, int index, int difficulty) {
            this.title = title;
            this.index = index;
            this.difficulty = difficulty;
        }

        public String getTitle() { return this.title; }
        public int getIndex() { return this.index; }
        public int getDifficulty() { return this.difficulty; }

        @Override
        public int compareTo(Problem p) {
            return this.index - p.getIndex();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Problem> problems = new ArrayList<>(N);
        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            String title = input[0];
            int index = Integer.parseInt(input[1]);
            int difficulty = Integer.parseInt(input[2]);
            problems.add(new Problem(title, index, difficulty));
        }
        Collections.sort(problems);

        for (Problem problem : problems) {
            char letter = problem.getTitle().charAt(problem.getDifficulty() - 1);
            if (Character.isLowerCase(letter)) {
                letter = Character.toUpperCase(letter);
            }
            sb.append(letter);
        }

        System.out.println(sb);
        br.close();
    }
}