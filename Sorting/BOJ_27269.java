// BOJ - 27269
// Problem Sheet - https://www.acmicpc.net/problem/27269

import java.util.*;
import java.io.*;

public class Main {

    static class Student implements Comparable<Student> {
        private final int a;
        private final int h;

        public Student(int a, int h) {
            this.a = a;
            this.h = h;
        }

        public int getA() { return this.a; }
        public int getH() { return this.h; }

        @Override
        public int compareTo(Student s) {
            if (this.a == s.getA()) return s.getH() - this.h;
            else return this.a - s.getA();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>(n);
        for (int i=0 ; i<n ; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);
            students.add(new Student(a, h));
        }
        Collections.sort(students);

        int maxDiff = 0;
        for (int i=1 ; i<n ; i++) {
            int curDiff = Math.abs(students.get(i - 1).getH() - students.get(i).getH());
            maxDiff = Math.max(maxDiff, curDiff);
        }

        System.out.println(maxDiff);
        br.close();
    }
}
