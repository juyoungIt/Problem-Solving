// BOJ - 5957
// Problem Sheet - https://www.acmicpc.net/problem/5957

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Stack<Integer>> dishes = new ArrayList<>(3);
        for(int i=0 ; i<3 ; i++) {
            dishes.add(new Stack<>());
        }

        int numberOfDishes = Integer.parseInt(bf.readLine());
        for(int i=numberOfDishes ; i>0 ; i--) {
            dishes.get(0).push(i);
        }

        StringTokenizer st;
        while(dishes.get(2).size() < numberOfDishes) {
            st = new StringTokenizer(bf.readLine());
            int command = Integer.parseInt(st.nextToken());
            int numberOfProcessing = Integer.parseInt(st.nextToken());

            for(int i=0 ; i<numberOfProcessing ; i++) {
                if(!dishes.get(command-1).isEmpty()) {
                    dishes.get(command).push(dishes.get(command-1).pop());
                }
            }
        }

        while(!dishes.get(2).isEmpty()) {
            sb.append(dishes.get(2).pop()).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}