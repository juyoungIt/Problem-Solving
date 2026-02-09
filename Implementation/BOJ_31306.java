// BOJ - 31306
// Problem Sheet - https://www.acmicpc.net/problem/31306

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int vowelCount = 0;
        int yCount = 0;
        for (int i=0 ; i<input.length() ; i++) {
            char c = input.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            }
            if (c == 'y') {
                yCount++;
            }
        }
        System.out.printf("%d %d\n", vowelCount, vowelCount + yCount);
        br.close();
    }
}
