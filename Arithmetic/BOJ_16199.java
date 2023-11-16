// BOJ - 16199
// Problem Sheet - https://www.acmicpc.net/problem/16199

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] birth = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] base = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.printf("%d\n%d\n%d\n",
                getFullAge(base, birth),
                getCountingAge(base, birth),
                getYearAge(base, birth));

        br.close();
        System.exit(0);
    }

    private static int getFullAge(int[] base, int[] birth) {
        LocalDate baseDate = LocalDate.of(base[0], base[1], base[2]);
        LocalDate birthDate = LocalDate.of(birth[0], birth[1], birth[2]);
        return Period.between(birthDate, baseDate).getYears();
    }

    private static int getCountingAge(int[] base, int[] birth) {
        return base[0] - birth[0] + 1;
    }

    private static int getYearAge(int[] base, int[] birth) {
        return base[0] - birth[0];
    }
}