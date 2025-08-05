// BOJ - 25178
// Problem Sheet - https://www.acmicpc.net/problem/25178

import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static final String YES = "YES", NO = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String wordA = br.readLine();
        String wordB = br.readLine();
        if (isSameArrange(wordA, wordB)
                && isSameFrontAndBack(wordA, wordB)
                && isSamePart(wordA, wordB)) {
            System.out.println(YES);
        } else {
            System.out.println(NO);
        }
        br.close();
    }

    private static boolean isSameArrange(String a, String b) {
        int[] countA = new int[26];
        int[] countB = new int[26];
        for (int i=0 ; i<n ; i++) {
            countA[a.charAt(i) - 'a']++;
            countB[b.charAt(i) - 'a']++;
        }
        return Arrays.equals(countA, countB);
    }

    private static boolean isSameFrontAndBack(String a, String b) {
        return a.charAt(0) == b.charAt(0) && a.charAt(n - 1) == b.charAt(n - 1);
    }

    private static boolean isSamePart(String a, String b) {
        List<Character> listA = new ArrayList<>();
        List<Character> listB = new ArrayList<>();
        for (int i=0 ; i<n ; i++) {
            if (!isVowel(a.charAt(i))) listA.add(a.charAt(i));
            if (!isVowel(b.charAt(i))) listB.add(b.charAt(i));
        }
        for (int i=0 ; i<listA.size() ; i++) {
            if (listA.get(i) != listB.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}