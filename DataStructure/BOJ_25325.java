// BOJ - 25325
// Problem Sheet - https://www.acmicpc.net/problem/25325

import java.util.*;
import java.io.*;

public class Main {

    static class Student implements Comparable<Student> {
        private final String name;
        private final int likes;

        public Student(String name, int likes) {
            this.name = name;
            this.likes = likes;
        }

        public String getName() { return this.name; }
        public int getLikes() { return this.likes; }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(name).append(' ').append(likes);
            return sb.toString();
        }

        @Override
        public int compareTo(Student student) {
            if(this.likes != student.getLikes()) {
                return Integer.compare(this.likes, student.getLikes()) * -1;
            } else {
                return this.name.compareTo(student.getName());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> countMapper = new HashMap<>(); // 카운트 정보 유지

        int n = Integer.parseInt(bf.readLine()); // 학생의 수
        List<Student> results = new ArrayList<>(n); // 처리된 결과를 저장

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            countMapper.put(st.nextToken(), 0);
        }

        for(int i=0 ; i<n ; i++) {
            String[] likes = bf.readLine().split(" ");
            for(String name : likes) {
                countMapper.put(name, countMapper.get(name) + 1);
            }
        }

        for(Map.Entry<String, Integer> entry : countMapper.entrySet()) {
            results.add(new Student(entry.getKey(), entry.getValue()));
        }
        Collections.sort(results);

        for(Student student : results) {
            System.out.println(student);
        }

        bf.close();
        System.exit(0);
    }
}