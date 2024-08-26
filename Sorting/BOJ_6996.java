// BOJ - 6996
// Problem Sheet - https://www.acmicpc.net/problem/6996

import java.util.*;
import java.io.*;

public class Main {

    private static final String IS_VALID = "%s & %s are anagrams.";
    private static final String IS_NOT_VALID = "%s & %s are NOT anagrams.";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            String wordA = st.nextToken();
            String wordB = st.nextToken();
            if (getSortedWord(wordA).equals(getSortedWord(wordB))) {
                sb.append(String.format(IS_VALID, wordA, wordB)).append("\n");
            } else {
                sb.append(String.format(IS_NOT_VALID, wordA, wordB)).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static String getSortedWord(String src) {
        StringBuilder sb = new StringBuilder();
        char[] letters = src.toCharArray();
        Arrays.sort(letters);
        for (char letter : letters) {
            sb.append(letter);
        }
        return sb.toString();
    }
}