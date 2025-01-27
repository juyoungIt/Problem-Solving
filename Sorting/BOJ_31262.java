// BOJ - 31262
// Problem Sheet - https://www.acmicpc.net/problem/31262

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        char[] letters = new char[3];
        char[] digits = new char[3];
        for (int i=0 ; i<input.length() ; i++) {
            if (i < 3) letters[i] = input.charAt(i);
            else digits[i - 3] = input.charAt(i);
        }
        Arrays.sort(letters);
        Arrays.sort(digits);

        for (int i=0 ; i<3 ; i++) {
            sb.append(letters[i]).append(digits[2 - i]);
        }

        System.out.println(sb);
        br.close();
    }
}