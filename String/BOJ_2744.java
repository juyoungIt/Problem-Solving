// BOJ - 2744
// Problem Sheet - https://www.acmicpc.net/problem/2744

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = bf.readLine();

        for(char letter : input.toCharArray()) {
            if((int)letter >= 65 && (int)letter <= 90) {
                sb.append(Character.toLowerCase(letter));
            } else if((int)letter >= 97 && (int)letter <= 122) {
                sb.append(Character.toUpperCase(letter));
            } else {
                throw new IllegalArgumentException("Invalid Arguments");
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}