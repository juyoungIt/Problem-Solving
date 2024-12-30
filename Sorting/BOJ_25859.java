// BOJ - 25859
// Problem Sheet - https://www.acmicpc.net/problem/25859

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] frequencies = new int[26][2];
        char[] letters = br.readLine().toCharArray();
        for (char letter : letters) {
            int index = letter - 'a';
            frequencies[index][0] = index;
            frequencies[index][1]++;
        }
        Arrays.sort(frequencies, (e1, e2) -> {
            if (e1[1] == e2[1]) return e1[0] - e2[0];
            return e2[1] - e1[1];
        });

        for (int i=0 ; i<26 ; i++) {
            char letter = (char) (frequencies[i][0] + 'a');
            int count = frequencies[i][1];
            sb.append(String.valueOf(letter).repeat(Math.max(0, count)));
        }

        System.out.println(sb);
        br.close();
    }
}