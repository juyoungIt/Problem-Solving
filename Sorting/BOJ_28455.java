// BOJ - 28455
// Problem Sheet - https://www.acmicpc.net/problem/28455

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> levels = new ArrayList<>();
        for (int i=0 ; i<n ; i++) {
            levels.add(Integer.parseInt(br.readLine()));
        }
        levels.sort(Collections.reverseOrder());

        int levelSum = 0;
        int incrementSum = 0;
        for (int i=0 ; i<Math.min(n, 42) ; i++) {
            levelSum += levels.get(i);
            incrementSum += getIncrement(levels.get(i));
        }

        System.out.printf("%d %d\n", levelSum, incrementSum);
        br.close();
    }

    private static int getIncrement(int level) {
        int increment = 0;
        if (level >= 60) increment++;
        if (level >= 100) increment++;
        if (level >= 140) increment++;
        if (level >= 200) increment++;
        if (level >= 250) increment++;
        return increment;
    }
}