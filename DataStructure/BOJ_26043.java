// BOJ - 26043
// Problem Sheet - https://www.acmicpc.net/problem/26043

import java.util.*;
import java.io.*;

public class Main {

    static class Student {
        private final int number; // 학생 번호
        private final int desiredMenu; // 원하는 메뉴번호

        public Student(int number, int desiredMenu) {
            this.number = number;
            this.desiredMenu = desiredMenu;
        }

        public int getNumber() { return this.number; }
        public int getDesiredMenu() { return this.desiredMenu; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Queue<Student> waitings = new LinkedList<>(); // 식당 대기열
        PriorityQueue<Integer> groupA = new PriorityQueue<>();
        PriorityQueue<Integer> groupB = new PriorityQueue<>();
        PriorityQueue<Integer> groupC = new PriorityQueue<>();

        int informationCount = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<informationCount ; i++) {
            String[] tokens = bf.readLine().split(" ");
            int informationType = Integer.parseInt(tokens[0]);
            if(informationType == 1) {
                int studentNumber = Integer.parseInt(tokens[1]);
                int desiredMenu = Integer.parseInt(tokens[2]);
                waitings.add(new Student(studentNumber, desiredMenu));
            } else {
                int menuNumber = Integer.parseInt(tokens[1]);
                if(waitings.peek().getDesiredMenu() == menuNumber) {
                    groupA.add(waitings.poll().getNumber());
                } else {
                    groupB.add(waitings.poll().getNumber());
                }
            }
        }

        while(!waitings.isEmpty()) {
            groupC.add(waitings.poll().getNumber());
        }

        if(!groupA.isEmpty()) {
            while(!groupA.isEmpty()) {
                System.out.print(groupA.poll() + " ");
            }
            System.out.println();
        } else {
            System.out.println("None");
        }

        if(!groupB.isEmpty()) {
            while(!groupB.isEmpty()) {
                System.out.print(groupB.poll() + " ");
            }
            System.out.println();
        } else {
            System.out.println("None");
        }

        if(!groupC.isEmpty()) {
            while(!groupC.isEmpty()) {
                System.out.print(groupC.poll() + " ");
            }
            System.out.println();
        } else {
            System.out.println("None");
        }

        bf.close();
        System.exit(0);
    }
}