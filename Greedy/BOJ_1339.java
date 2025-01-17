// BOJ - 1339
// Problem Sheet - https://www.acmicpc.net/problem/1339

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static String[] words;
    private static final int[] weights = new int[26];

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        for (int i=0 ; i<N ; i++) {
            words[i] = br.readLine();
        }
        br.close();
    }

    private static int solve() {
        int maxSum = 0;
        updateLetterWeight();
        Arrays.sort(weights);
        int base = 9;
        for (int i=25 ; i>=0 ; i--) {
            if (weights[i] <= 0) break;
            maxSum += base-- * weights[i];
        }
        return maxSum;
    }

    private static void updateLetterWeight() {
        for (String word : words) {
            for (int i=0 ; i<word.length() ; i++) {
                weights[word.charAt(i) - 'A'] += (int) Math.pow(10, word.length() - i - 1);
            }
        }
    }
}