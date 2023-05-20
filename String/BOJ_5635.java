// BOJ - 5635
// Problem Sheet - https://www.acmicpc.net/problem/5635

import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class Main {

    static class Student implements Comparable<Student> {
        private final String name;
        private final LocalDate birthDate;

        public Student(String name, int year, int month, int day) {
            this.name = name;
            this.birthDate = LocalDate.of(year, month, day);
        }

        public String getName() { return this.name; }
        public LocalDate getBirthDate() { return this.birthDate; }

        @Override
        public int compareTo(Student student) {
            return this.birthDate.compareTo(student.getBirthDate()) * -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int numberOfStudents = Integer.parseInt(bf.readLine());
        List<Student> students = new ArrayList<>(numberOfStudents);
        for(int i=0 ; i<numberOfStudents ; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            students.add(new Student(name, year, month, day));
        }

        Collections.sort(students);
        sb.append(students.get(0).getName())
                .append("\n")
                .append(students.get(numberOfStudents-1).getName());

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}