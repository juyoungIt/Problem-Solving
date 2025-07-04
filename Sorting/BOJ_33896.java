// BOJ - 33896
// Problem Sheet - https://www.acmicpc.net/problem/33896

import java.util.*;
import java.io.*;

public class Main {

    static class Student implements Comparable<Student> {
        String name;
        int score;
        int risk;
        int cost;

        public Student(String name, int score, int risk, int cost) {
            this.name = name;
            this.score = score;
            this.risk = risk;
            this.cost = cost;
        }

        public int getScholarshipScore() {
            return (int) Math.pow(score, 3) / (cost * (risk + 1));
        }

        @Override
        public int compareTo(Student s) {
            int scholarshipScoreA = this.getScholarshipScore();
            int scholarshipScoreB = s.getScholarshipScore();
            if (scholarshipScoreA == scholarshipScoreB) {
                if (this.cost == s.cost) {
                    return this.name.compareTo(s.name);
                }
                return this.cost - s.cost;
            }
            return scholarshipScoreB - scholarshipScoreA;
        }
    }

    private static int n;
    private static Student[] students;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        students = new Student[n];
        for (int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split(" ");
            String name = row[0];
            int score = Integer.parseInt(row[1]);
            int risk = Integer.parseInt(row[2]);
            int cost = Integer.parseInt(row[3]);
            students[i] = new Student(name, score, risk, cost);
        }
        br.close();
    }

    private static String solve() {
        Arrays.sort(students);
        return students[1].name;
    }

}
