// BOJ - 4775
// Problem Sheet - https://www.acmicpc.net/problem/4775

import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static Set<String> dict;
    private static List<String>[] mails;

    private static final String CORRECT = "Email %d is spelled correctly.";
    private static final String INCORRECT = "Email %d is not spelled correctly.";
    private static final String EOO = "End of Output";

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dict = new HashSet<>();
        for (int i=0 ; i<N ; i++) {
            dict.add(br.readLine());
        }
        M = Integer.parseInt(br.readLine());
        mails = new List[M];
        for (int i=0 ; i<M ; i++) {
            mails[i] = new ArrayList<>();
            while (true) {
                String word = br.readLine();
                if (word.equals("-1")) break;
                mails[i].add(word);
            }
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<mails.length ; i++) {
            boolean isCorrect = true;
            List<String> incorrectWords = new ArrayList<>();
            for (String word : mails[i]) {
                if (!dict.contains(word)) {
                    isCorrect = false;
                    incorrectWords.add(word);
                }
            }
            sb.append(isCorrect ? String.format(CORRECT, i + 1) : String.format(INCORRECT, i + 1)).append("\n");
            if (isCorrect) continue;
            for (String word : incorrectWords) {
                sb.append(word).append("\n");
            }
        }
        sb.append(EOO).append("\n");
        return sb.toString();
    }
}