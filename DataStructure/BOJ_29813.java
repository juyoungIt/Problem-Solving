// BOJ - 29813
// Problem Sheet - https://www.acmicpc.net/problem/29813

import java.util.*;
import java.io.*;

public class Main {

    static class Student {
        private final String initial;
        private final int lastTwoNumbers;

        public Student(String initial, int lastTwoNumbers) {
            this.initial = initial;
            this.lastTwoNumbers = lastTwoNumbers;
        }

        public String getInitial() { return this.initial; }
        public int getLastTwoNumbers() { return this.lastTwoNumbers; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Queue<Student> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            String initial = st.nextToken();
            int studentNumber = Integer.parseInt(st.nextToken());
            queue.add(new Student(initial, studentNumber));
        }

        while (queue.size() > 1) {
            Student frontStudent = queue.poll();
            for (int i=0 ; i<frontStudent.getLastTwoNumbers()-1 ; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }

        if (!queue.isEmpty()) {
            System.out.println(queue.poll().getInitial());
        }

        br.close();
        System.exit(0);
    }
}