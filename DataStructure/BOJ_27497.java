// BOJ - 27497
// Problem Sheet - https://www.acmicpc.net/problem/27497

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Character> characters = new LinkedList<>();
        Stack<Boolean> insertDirections = new Stack<>();

        int numberOfClicks = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfClicks ; i++) {
            String[] commands = bf.readLine().split(" ");
            if(Integer.parseInt(commands[0]) == 1) {
                characters.addLast(commands[1].charAt(0));
                insertDirections.push(false);
            } else if(Integer.parseInt(commands[0]) == 2) {
                characters.addFirst(commands[1].charAt(0));
                insertDirections.push(true);
            } else {
                if(characters.size() > 0) {
                    if(insertDirections.pop()) {
                        characters.pollFirst();
                    } else {
                        characters.pollLast();
                    }
                }
            }
        }

        if(characters.size() == 0) {
            System.out.println(0);
        } else {
            for(char character : characters) {
                sb.append(character);
            }
            System.out.println(sb);
        }

        bf.close();
        System.exit(0);
    }
}