// BOJ - 23056
// Problem Sheet - https://www.acmicpc.net/problem/23056

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    static class Student implements Comparable<Student> {
        private final int classId;
        private final String name;

        public Student(int classId, String name) {
            this.classId = classId;
            this.name = name;
        }

        public int getClassId() { return this.classId; }
        public String getName() { return this.name; }

        @Override
        public int compareTo(Student s) {
            if (this.classId == s.getClassId()) {
                if (this.name.length() == s.getName().length()) {
                    return this.name.compareTo(s.getName());
                }
                return this.name.length() - s.getName().length();
            }
            return this.classId - s.getClassId();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        List<List<Student>> students = new ArrayList<>(N);
        for (int i=0 ; i<N ; i++) {
            students.add(i, new ArrayList<>());
        }
        while (true) {
            input = br.readLine().split(" ");
            if (input[0].equals("0") && input[1].equals("0")) break;
            int classId = Integer.parseInt(input[0]);
            String name = input[1];
            students.get(classId - 1).add(new Student(classId, name));
        }

        List<Student> blueTeam = new ArrayList<>();
        List<Student> whiteTeam = new ArrayList<>();
        for (int i=0 ; i<N ; i+=2) {
            blueTeam.addAll(students.get(i)
                    .stream()
                    .limit(M)
                    .collect(Collectors.toList())
            );
        }
        for (int i=1 ; i<N ; i+=2) {
            whiteTeam.addAll(students.get(i)
                    .stream()
                    .limit(M)
                    .collect(Collectors.toList())
            );
        }
        Collections.sort(blueTeam);
        Collections.sort(whiteTeam);

        for (Student student : blueTeam) {
            sb.append(student.getClassId())
                    .append(" ")
                    .append(student.getName())
                    .append("\n");
        }

        for (Student student : whiteTeam) {
            sb.append(student.getClassId())
                    .append(" ")
                    .append(student.getName())
                    .append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}