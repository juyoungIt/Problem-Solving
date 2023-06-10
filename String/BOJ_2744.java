// BOJ - 2744
// Problem Sheet - https://www.acmicpc.net/problem/2744

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = bf.readLine();
        for(int i=0 ; i<input.length() ; i++) {
            char letter = input.charAt(i);
            if(Character.isUpperCase(letter)) {
                sb.append(Character.toLowerCase(letter));
            } else if(Character.isLowerCase(letter)) {
                sb.append(Character.toUpperCase(letter));
            } else {
                throw new IllegalArgumentException();
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}