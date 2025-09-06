// BOJ - 10770
// Problem Sheet - https://www.acmicpc.net/problem/10770

import java.util.*;
import java.io.*;

public class Main {
    
    static boolean[] isVowel = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i=0 ; i<26 ; i++) {
            if (!isVowel((char) (i + 'a'))) continue;
            isVowel[i] = true;
        }

        String s = br.readLine();
        for (int i=0 ; i<s.length() ; i++) {
            sb.append(s.charAt(i));
            if (isVowel[s.charAt(i) - 'a']) continue;
            sb.append(getC1(s.charAt(i))).append(getC2(s.charAt(i)));
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static char getC1(char c) {
        int left = c - 'a', right = c - 'a';
        while (true) {
            left--;
            right++;
            if (left >= 0 && isVowel[left]) return (char) (left + 'a');
            if (right < 26 && isVowel[right]) return (char) (right + 'a');
        }
    }

    private static char getC2(char c) {
        for (int i=c-'a'+1 ; i<26 ; i++) {
            if (i == 25) return 'z';
            if (isVowel[i]) continue;
            return (char) (i + 'a');
        }
        return 'z';
    }

}