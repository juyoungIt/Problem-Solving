// BOJ - 10657
// Problem Sheet - https://www.acmicpc.net/problem/10657

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Stack<Integer> horses = new Stack<>();
        Stack<Integer> groups = new Stack<>();
        int numberOfHorses = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfHorses ; i++) {
            st = new StringTokenizer(bf.readLine());
            int location = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            horses.add(speed);
        }

        while(!horses.isEmpty()) {
            if(groups.isEmpty() || groups.peek() >= horses.peek()) {
                groups.push(horses.pop());
                continue;
            }
            horses.pop();
        }

        System.out.println(groups.size());

        bf.close();
        System.exit(0);
    }
}