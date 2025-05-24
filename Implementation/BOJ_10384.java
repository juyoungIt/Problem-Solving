// BOJ - 10384
// Problem Sheet - https://www.acmicpc.net/problem/10384

import java.io.*;

public class Main {

    private static final String NOT = "Not a pangram";
    private static final String SINGLE = "Pangram!";
    private static final String DOUBLE = "Double pangram!!";
    private static final String TRIPLE = "Triple pangram!!!";
    private static final String OUTPUT_FORMAT = "Case %d: %s";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i=0 ; i<n ; i++) {
            int[] counts = new int[26];
            String str = br.readLine();
            for (int j=0 ; j<str.length() ; j++) {
                int index = Character.toLowerCase(str.charAt(j)) - 'a';
                if (index < 0 || index >= 26) continue;
                counts[index]++;
            }
            int result = checkPangram(counts);
            if (result == 1) sb.append(String.format(OUTPUT_FORMAT, i + 1, SINGLE));
            else if (result == 2) sb.append(String.format(OUTPUT_FORMAT, i + 1, DOUBLE));
            else if (result == 3) sb.append(String.format(OUTPUT_FORMAT, i + 1, TRIPLE));
            else sb.append(String.format(OUTPUT_FORMAT, i + 1, NOT));
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int checkPangram(int[] counts) {
        int minUsage = Integer.MAX_VALUE;
        for (int i=0 ; i<26 ; i++) {
            minUsage = Math.min(minUsage, counts[i]);
        }
        return minUsage;
    }

}