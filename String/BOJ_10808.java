// BOJ - 10808
// Problem Sheet - https://www.acmicpc.net/problem/10808

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] alphaCounts = new int[26];
        String word = bf.readLine();
        for(char letter : word.toCharArray()) {
            alphaCounts[letter-'a']++;
        }

        for(int i=0 ; i<26 ; i++) {
            sb.append(alphaCounts[i]).append(" ");
        }
        sb.append("\n");

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}