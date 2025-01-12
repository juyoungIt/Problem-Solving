// BOJ - 33135
// Problem Sheet - https://www.acmicpc.net/problem/33135

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isUsed = new boolean[26];

        String input = br.readLine();
        for (int i=0 ; i<input.length() ; i++) {
            isUsed[input.charAt(i) - 'A'] = true;
        }

        int uniqueCount = 0;
        for (boolean used : isUsed) {
            if (used) uniqueCount++;
        }

        System.out.println(input.length() - uniqueCount);
        br.close();
    }
}
