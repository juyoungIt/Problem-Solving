// BOJ - 9056
// Problem Sheet - https://www.acmicpc.net/problem/9056

import java.util.*;
import java.io.*;

public class Main {

    private static final String VALID = "YES";
    private static final String INVALID = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<Character, Boolean> wordBank = new HashMap<>();
        int numberOfTestCases = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfTestCases ; i++) {
            boolean isValid = false;
            st = new StringTokenizer(bf.readLine());
            char[] bankElements = st.nextToken().toCharArray();
            for(char bankElement : bankElements) {
                wordBank.put(bankElement, false);
            }

            char[] testWordElements = st.nextToken().toCharArray();
            for(char testWordElement : testWordElements) {
                if(!wordBank.containsKey(testWordElement)) {
                    break;
                }
                wordBank.put(testWordElement, true);
            }
            if(!wordBank.containsValue(false)) {
                isValid = true;
            }

            sb.append((isValid) ? VALID : INVALID).append("\n");
            wordBank.clear();
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}