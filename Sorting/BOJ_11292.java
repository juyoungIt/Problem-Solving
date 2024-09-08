// BOJ - 11292
// Problem Sheet - https://www.acmicpc.net/problem/11292

import java.util.*;
import java.io.*;

public class Main {

    static class Student implements Comparable<Student> {
        private final int inputIndex;
        private final String name;
        private final double height;

        public Student(int inputIndex, String name, double height) {
            this.inputIndex = inputIndex;
            this.name = name;
            this.height = height;
        }

        public int getInputIndex() { return this.inputIndex; }
        public String getName() { return this.name; }
        public double getHeight() { return this.height; }

        @Override
        public int compareTo(Student s) {
            if (this.height == s.getHeight()) {
                return this.inputIndex - s.getInputIndex();
            }
            return Double.compare(s.getHeight(), this.height);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            Student[] students = new Student[n];
            for (int i=0 ; i<n ; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                double height = Double.parseDouble(st.nextToken());
                students[i] = new Student(i, name, height);
            }
            Arrays.sort(students);
            double maxHeight = students[0].getHeight();
            for (Student student : students) {
                if (student.getHeight() == maxHeight) {
                    sb.append(student.getName()).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}