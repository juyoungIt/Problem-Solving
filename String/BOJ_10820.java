// BOJ - 10820
// Problem Sheet - https://www.acmicpc.net/problem/10820

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = "";
        while((input = bf.readLine()) != null) {
            int[] counts = new int[4];
            for(char letter : input.toCharArray()) {
                if(Character.isLowerCase(letter)) {
                    counts[0]++;
                } else if(Character.isUpperCase(letter)) {
                    counts[1]++;
                } else if(Character.isDigit(letter)) {
                    counts[2]++;
                } else if(letter == ' ') {
                    counts[3]++;
                } else {
                    throw new IllegalArgumentException("Invalid letter...");
                }
            }
            for(int count : counts) {
                sb.append(count).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}