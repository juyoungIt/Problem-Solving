// BOJ - 32185
// Problem Sheet - https://www.acmicpc.net/problem/32185

import java.util.*;
import java.io.*;

public class Main {

    static class Student implements Comparable<Student> {
        private final int i;
        private final int v;
        private final int p;
        private final int s;

        public Student(int i, int v, int p, int s) {
            this.i = i;
            this.v = v;
            this.p = p;
            this.s = s;
        }

        public int getI() { return this.i; }
        public int getStat() { return this.v + this.p + this.s; }

        @Override
        public int compareTo(Student s) {
            return s.getStat() - this.getStat();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);
        int s = Integer.parseInt(input[2]);
        Student studentJ = new Student(0, v, p, s);

        PriorityQueue<Student> students = new PriorityQueue<>();
        for (int i=1 ; i<=N ; i++) {
            input = br.readLine().split(" ");
            v = Integer.parseInt(input[0]);
            p = Integer.parseInt(input[1]);
            s = Integer.parseInt(input[2]);
            Student student = new Student(i, v, p, s);
            if (student.getStat() > studentJ.getStat()) {
                continue;
            }
            students.add(student);
        }

        int count = 1;
        sb.append(studentJ.getI()).append(" ");
        while (!students.isEmpty() && count < M) {
            sb.append(students.poll().getI()).append(" ");
            count++;
        }

        System.out.println(sb);
        br.close();
    }
}