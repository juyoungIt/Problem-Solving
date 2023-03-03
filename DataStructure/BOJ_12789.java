// BOJ - 12789
// Problem Sheet - https://www.acmicpc.net/problem/12789

import java.util.*;
import java.io.*;

public class Main {

    private static final String SUCCESS = "Nice";
    private static final String FAILED = "Sad";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> waitings = new Stack<>();
        int nextNumber = 1; // 가장 마지막
        boolean isSuccess = true;

        int numberOfStudents = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        List<Integer> sequence = new ArrayList<>(numberOfStudents);
        for(int i=0 ; i<numberOfStudents ; i++) {
            sequence.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0 ; i<numberOfStudents ; i++) {
            int studentNumber = sequence.get(i);
            if(studentNumber == nextNumber) {
                nextNumber++;
            } else {
                if(waitings.isEmpty()) {
                    waitings.add(studentNumber);
                } else {
                    if(waitings.peek() == nextNumber) {
                        waitings.pop();
                        nextNumber++;
                        i--;
                    } else {
                        waitings.add(studentNumber);
                    }
                }
            }
        }

        while(!waitings.isEmpty()) {
            if(waitings.peek() != nextNumber) {
                isSuccess = false;
                break;
            }
            waitings.pop();
            nextNumber++;
        }

        if(isSuccess) {
            System.out.println(SUCCESS);
        } else {
            System.out.println(FAILED);
        }

        bf.close();
        System.exit(0);
    }
}