// BOJ - 10825
// Problem Sheet - https://www.acmicpc.net/problem/10825

import java.util.*;
import java.io.*;

public class Main {

    static class Student implements Comparable<Student> {
        private final String name;
        private final int korScore;
        private final int engScore;
        private final int mathScore;

        public Student(String name, int korScore, int engScore, int mathScore) {
            this.name = name;
            this.korScore = korScore;
            this.engScore = engScore;
            this.mathScore = mathScore;
        }

        public String getName() { return this.name; }
        public int getKorScore() { return this.korScore; }
        public int getEngScore() { return this.engScore; }
        public int getMathScore() { return this.mathScore; }

        @Override
        public int compareTo(Student student) {
            if(this.korScore != student.getKorScore()) {
                return (this.korScore - student.getKorScore()) * -1;
            } else if(this.engScore != student.getEngScore()) {
                return this.engScore - student.getEngScore();
            } else if(this.mathScore != student.getMathScore()) {
                return (this.mathScore - student.getMathScore()) * -1;
            } else {
                return this.name.compareTo(student.getName());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        Student[] students = new Student[N];
        for(int i=0 ; i<N ; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int korScore = Integer.parseInt(st.nextToken());
            int engScore = Integer.parseInt(st.nextToken());
            int mathScore = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, korScore, engScore, mathScore);
        }

        Arrays.sort(students);
        Arrays.stream(students).forEach(student -> sb.append(student.getName()).append("\n"));
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}