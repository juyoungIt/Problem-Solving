// BOJ - 18155
// Problem Sheet - https://www.acmicpc.net/problem/18155

import java.util.*;
import java.io.*;

public class Main {

    enum RESULT {
        VALID, INVALID
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Character, Character> leetspeak = new HashMap<>();
        leetspeak.put('0', 'O'); leetspeak.put('1', 'L');
        leetspeak.put('2', 'Z'); leetspeak.put('3', 'E');
        leetspeak.put('5', 'S'); leetspeak.put('6', 'B');
        leetspeak.put('7', 'T'); leetspeak.put('8', 'B');

        String[] row = br.readLine().split(" ");
        int n = Integer.parseInt(row[0]);
        int m = Integer.parseInt(row[1]);
        String[] badWords = new String[n];
        for (int i=0 ; i<n ; i++) {
            badWords[i] = br.readLine();
        }
        for (int i=0 ; i<m ; i++) {
            char[] plate = br.readLine().toCharArray();
            for (int j=0 ; j<plate.length ; j++) {
                if (!leetspeak.containsKey(plate[j])) continue;
                plate[j] = leetspeak.get(plate[j]);
            }
            StringBuilder buffer = new StringBuilder();
            for (int j=0 ; j<plate.length ; j++) {
                buffer.append(plate[j]);
            }
            boolean isValid = true;
            String coverted = buffer.toString();
            for (String badWord : badWords) {
                if (coverted.contains(badWord)) {
                    isValid = false;
                    break;
                }
            }
            sb.append(isValid ? RESULT.VALID : RESULT.INVALID).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}
