// BOJ - 6513
// Problem Sheet - https://www.acmicpc.net/problem/6513

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int numberOfIrregularWords = Integer.parseInt(st.nextToken());
        int numberOfCheckingWords = Integer.parseInt(st.nextToken());

        Map<String, String> irregularCases = new HashMap<>();
        for(int i=0 ; i<numberOfIrregularWords ; i++) {
            st = new StringTokenizer(bf.readLine());
            irregularCases.put(st.nextToken(), st.nextToken());
        }

        for(int i=0 ; i<numberOfCheckingWords ; i++) {
            String word = bf.readLine();
            sb.append(getPluralWord(irregularCases, word)).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static boolean isVowel(char token) {
        return token == 'a'
                || token == 'e'
                || token == 'i'
                || token == 'o'
                || token == 'u';
    }

    private static String getPluralWord(Map<String, String> irregularCases, String word) {
        StringBuilder sb = new StringBuilder();
        if(irregularCases.containsKey(word)) {
            return irregularCases.get(word);
        } else if(word.charAt(word.length()-1) == 'y' && !isVowel(word.charAt(word.length()-2))) {
            sb.append(word, 0, word.length()-1).append("ies");
            return sb.toString();
        } else if(word.endsWith("o")
                || word.endsWith("s")
                || word.endsWith("x")
                || word.endsWith("ch")
                || word.endsWith("sh")) {
            sb.append(word).append("es");
            return sb.toString();
        } else {
            sb.append(word).append("s");
            return sb.toString();
        }
    }
}