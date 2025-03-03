// BOJ - 32978
// Problem Sheet - https://www.acmicpc.net/problem/32978

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] ingredients = new String[N];
        String[] row = br.readLine().split(" ");
        System.arraycopy(row, 0, ingredients, 0, N);
        row = br.readLine().split(" ");
        Set<String> used = new HashSet<>(Arrays.asList(row).subList(0, N - 1));

        String notUsed = "";
        for (String ingredient : ingredients) {
            if (!used.contains(ingredient)) {
                notUsed = ingredient;
                break;
            }
        }

        System.out.println(notUsed);
        br.close();
    }
}