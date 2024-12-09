// BOJ - 29018
// Problem Sheet - https://www.acmicpc.net/problem/29018

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.charAt(0) == '#') break;
            sb.append(getSortedString(input)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static String getSortedString(String src) {
        StringBuilder sb = new StringBuilder();
        String[] letters = src.split("");
        Arrays.sort(letters, (l1, l2) -> {
            int priorityA = getPriorityLevel(l1.charAt(0));
            int priorityB = getPriorityLevel(l2.charAt(0));
            if (priorityA == priorityB) {
                return Character.compare(l1.charAt(0), l2.charAt(0));
            }
            return priorityA - priorityB;
        });
        Arrays.stream(letters).forEach(sb::append);
        return sb.toString();
    }

    private static int getPriorityLevel(char letter) {
        if (Character.isLowerCase(letter)) return 1;
        else if (Character.isUpperCase(letter)) return 2;
        else return 3;
    }
}