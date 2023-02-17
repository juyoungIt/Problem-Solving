// BOJ - 5263
// Problem Sheet - https://www.acmicpc.net/problem/5263

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> countMapper = new HashMap<>();

        String[] tokens = bf.readLine().split(" ");
        int numberOfDancers = Integer.parseInt(tokens[0]);
        int groupUnit = Integer.parseInt(tokens[1]);

        for(int i=0 ; i<numberOfDancers ; i++) {
            int number = Integer.parseInt(bf.readLine());
            if(!countMapper.containsKey(number)) {
                countMapper.put(number, 1);
            } else {
                countMapper.put(number, countMapper.get(number) + 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : countMapper.entrySet()) {
            if(entry.getValue() % groupUnit != 0) {
                System.out.println(entry.getKey());
                break;
            }
        }

        bf.close();
        System.exit(0);
    }
}