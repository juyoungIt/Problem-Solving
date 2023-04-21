// BOJ - 5430
// Problem Sheet - https://www.acmicpc.net/problem/5430

import java.util.*;
import java.io.*;

public class Main {

    private static final String ERROR = "error";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        Deque<String> deque = new LinkedList<>();
        for(int i=0 ; i<numberOfTestCases ; i++) {
            boolean directionIsFront = true;
            boolean isValid = true;
            char[] commands = bf.readLine().toCharArray();
            int arrSize = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine(), "[,]");

            for(int j=0 ; j<arrSize ; j++) {
                deque.addLast(st.nextToken());
            }

            for(char command : commands) {
                if(command == 'R') {
                    directionIsFront = !directionIsFront;
                } else if(command == 'D') {
                    if(deque.isEmpty()) {
                        deque.add(ERROR);
                        isValid = false;
                        break;
                    }
                    if(directionIsFront) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            if(isValid) {
                sb.append(buildDequeString(deque, directionIsFront)).append("\n");
            } else {
                sb.append(deque.poll()).append("\n");
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static String buildDequeString(Deque<String> deque, boolean directionIsFront) {
        StringJoiner sj = new StringJoiner(",", "[", "]");

        while(!deque.isEmpty()) {
            if(directionIsFront) {
                sj.add(deque.pollFirst());
            } else {
                sj.add(deque.pollLast());
            }
        }

        return sj.toString();
    }
}