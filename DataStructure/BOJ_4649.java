// BOJ - 4649
// Problem Sheet - https://www.acmicpc.net/problem/4649

import java.util.*;
import java.io.*;

public class Main {

    private static final String SERVICED = "All customers tanned successfully.\n";
    private static final String UNSERVICED = "%d customer(s) walked away.\n";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String[] tokens = bf.readLine().split(" ");
            if(Integer.parseInt(tokens[0]) == 0) {
                break;
            }
            int capacity = Integer.parseInt(tokens[0]);
            Map<Character, Integer> visitedCustomers = new HashMap<>();
            char[] customers = tokens[1].toCharArray();
            List<Character>[] queue = new List[2];
            queue[0] = new LinkedList<>();
            queue[1] = new LinkedList<>();
            int unserviced = 0; // 서비스를 받지 못한 소비자의 수

            for(char customer : customers) {
                if(!visitedCustomers.containsKey(customer)) { // 도착한 경우
                    if(queue[0].size() < capacity) {
                        queue[0].add(customer);
                        visitedCustomers.put(customer, 0);
                    } else {
                        queue[1].add(customer);
                        visitedCustomers.put(customer, 1);
                    }
                } else { // 떠나는 경우
                    if(visitedCustomers.get(customer) == 0) { // 사용자 열에 있음
                        queue[0].remove(queue[0].indexOf(customer));
                    } else { // 대기열에 있음
                        unserviced++;
                        queue[1].remove(queue[1].indexOf(customer));
                    }
                }
            }

            if(unserviced > 0) {
                sb.append(String.format(UNSERVICED, unserviced));
            } else {
                sb.append(SERVICED);
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}