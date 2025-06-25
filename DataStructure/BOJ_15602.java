// BOJ - 15602
// Problem Sheet - https://www.acmicpc.net/problem/15602

import java.util.*;
import java.io.*;

public class Main {

    private static int n, m;
    private static String s;
    private static Map<String, List<String>> cd, icd;
    private static final String CORRECT = "correct", INCORRECT = "incorrect";

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();
        m = Integer.parseInt(br.readLine());
        cd = new HashMap<>();
        icd = new HashMap<>();
        for (int i=0 ; i<m ; i++) {
            String[] row = br.readLine().split(" ");
            String d = row[0];
            String e = row[1];
            String c = row[2];
            if (c.equals(CORRECT)) {
                if (!cd.containsKey(d)) cd.put(d, new ArrayList<>());
                cd.get(d).add(e);
            } else {
                if (!icd.containsKey(d)) icd.put(d, new ArrayList<>());
                icd.get(d).add(e);
            }
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        long totalCount = 0;
        long correctCount = 0;
        boolean isCorrect = true;
        boolean isUnique = true;
        String[] words = s.split(" ");
        for (String word : words) {
            int cc = cd.containsKey(word) ? cd.get(word).size() : 0;
            int ic = icd.containsKey(word) ? icd.get(word).size() : 0;
            int searchCount = cc + ic;
            if (searchCount > 1) isUnique = false;
            if (searchCount == 1) {
                if (cd.containsKey(word)) sb.append(cd.get(word).get(0)).append(" ");
                else sb.append(icd.get(word).get(0)).append(" ");
            }
            totalCount = totalCount == 0 ? searchCount : totalCount * searchCount;
            correctCount = correctCount == 0 ? cc : correctCount * cc;
        }
        if (isUnique) return String.format("%s\n%s", sb, totalCount == correctCount ? CORRECT : INCORRECT);
        else return String.format("%d %s\n%d %s", correctCount, CORRECT, totalCount - correctCount, INCORRECT);
    }

}