// BOJ - 1713
// Problem Sheet - https://www.acmicpc.net/problem/1713

import java.util.*;
import java.io.*;

public class Main {

    static class Student implements Comparable<Student> {
        private final int number;
        private final int posted;
        private int recommendedCount;

        public Student(int number, int posted) {
            this.number = number;
            this.posted = posted;
            this.recommendedCount = 1;
        }

        public int getNumber() {
            return number;
        }

        public int getPosted() {
            return posted;
        }

        public int getRecommendedCount() {
            return recommendedCount;
        }

        public void getRecommed() {
            this.recommendedCount++;
        }

        @Override
        public int compareTo(Student o) {
            if(this.recommendedCount == o.getRecommendedCount()) {
                return o.getPosted() - this.posted;
            }
            return o.getRecommendedCount() - this.recommendedCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        List<Student> candidates = new LinkedList<>();
        int R = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1 ; i<=R ; i++) {
            int studentNumber = Integer.parseInt(st.nextToken());
            Student student = findStudent(candidates, studentNumber);
            if(student != null) {
                student.getRecommed();
                continue;
            }
            if(candidates.size() < N) {
                candidates.add(new Student(studentNumber, i));
            } else {
                Collections.sort(candidates);
                candidates.remove(candidates.size()-1);
                candidates.add(new Student(studentNumber, i));
            }
        }

        candidates.sort((s1, s2) -> s1.getNumber() - s2.getNumber());
        for(Student candidate : candidates) {
            sb.append(candidate.getNumber()).append(" ");
        }
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static Student findStudent(List<Student> students, int searchNumber) {
        for(Student student : students) {
            if(student.getNumber() == searchNumber) {
                return student;
            }
        }
        return null;
    }
}