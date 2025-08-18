// BOJ - 4446
// Problem Sheet - https://www.acmicpc.net/problem/4446

import java.util.*;
import java.io.*;

public class Main {

    static final char[] vows = { 'a', 'i', 'y', 'e', 'o', 'u' };
    static final char[] cons = { 'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f' };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input == null) break;
            for (int i=0 ; i<input.length() ; i++) {
                char c = input.charAt(i);
                if (!isAlpha(c)) {
                    sb.append(c);
                    continue;
                }
                if (isVowel(c)) {
                    int curIndex = getIndex(vows, c);
                    char result = vows[(curIndex + 3) % 6];
                    if (Character.isLowerCase(c)) sb.append(result);
                    else sb.append(Character.toUpperCase(result));
                } else {
                    int curIndex = getIndex(cons, c);
                    char result = cons[(curIndex + 10) % 20];
                    if (Character.isLowerCase(c)) sb.append(result);
                    else sb.append(Character.toUpperCase(result));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean isAlpha(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private static boolean isVowel(char c) {
        char target = Character.toLowerCase(c);
        for (char vow : vows) {
            if (vow == target) return true;
        }
        return false;
    }

    private static int getIndex(char[] arr, char c) {
        char target = Character.toLowerCase(c);
        for (int i=0 ; i<arr.length ; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

}