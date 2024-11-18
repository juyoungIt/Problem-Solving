// BOJ - 11609
// Problem Sheet - https://www.acmicpc.net/problem/11609

import java.util.*;
import java.io.*;

public class Main {

    static class Student implements Comparable<Student> {
        private final String firstName;
        private final String lastName;

        public Student(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() { return this.firstName; }
        public String getLastName() { return this.lastName; }

        @Override
        public int compareTo(Student s) {
            if (this.lastName.equals(s.getLastName())) {
                return this.firstName.compareTo(s.getFirstName());
            }
            return this.lastName.compareTo(s.getLastName());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        for (int i=0 ; i<N ; i++) {
            String[] name = br.readLine().split(" ");
            students[i] = new Student(name[0], name[1]);
        }
        Arrays.sort(students);

        for (int i=0 ; i<N ; i++) {
            sb.append(students[i].getFirstName())
                    .append(" ")
                    .append(students[i].getLastName())
                    .append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}