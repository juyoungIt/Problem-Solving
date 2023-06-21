// BOJ - 2476
// Problem Sheet - https://www.acmicpc.net/problem/2476

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numberOfParticipants = Integer.parseInt(bf.readLine());
        int[] rewards = new int[numberOfParticipants];
        for(int i=0 ; i<numberOfParticipants ; i++) {
            String[] numbers = bf.readLine().split(" ");
            if(numbers[0].charAt(0) == numbers[1].charAt(0)
                    && numbers[1].charAt(0) == numbers[2].charAt(0)) {
                rewards[i] = 10000 + Integer.parseInt(numbers[0]) * 1000;
            } else if(numbers[0].charAt(0) == numbers[1].charAt(0)
                    || numbers[1].charAt(0) == numbers[2].charAt(0)
                    || numbers[0].charAt(0) == numbers[2].charAt(0)) {
                String number;
                if(numbers[0].charAt(0) == numbers[1].charAt(0)
                        || numbers[0].charAt(0) == numbers[2].charAt(0)) {
                    number = numbers[0];
                } else {
                    number = numbers[1];
                }
                rewards[i] = 1000 + Integer.parseInt(number) * 100;
            } else {
                Arrays.sort(numbers);
                rewards[i] = Integer.parseInt(numbers[2]) * 100;
            }
        }

        Arrays.sort(rewards);
        System.out.println(rewards[numberOfParticipants-1]);

        bf.close();
        System.exit(0);
    }
}