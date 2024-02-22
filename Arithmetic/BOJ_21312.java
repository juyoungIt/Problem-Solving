// BOJ - 21312
// Problem Sheet - https://www.acmicpc.net/problem/21312

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cocktails = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int taste;
        if(isMixed(cocktails)) {
            taste = Arrays.stream(cocktails)
                    .filter(cocktail -> cocktail % 2 == 1)
                    .reduce(1, (acc, cocktail) -> acc * cocktail);
        } else {
            taste = Arrays.stream(cocktails)
                    .reduce(1, (acc, cocktail) -> acc * cocktail);
        }

        System.out.println(taste);

        br.close();
        System.exit(0);
    }

    private static boolean isMixed(int[] cocktails) {
        int type = cocktails[0] % 2;
        return Arrays.stream(cocktails)
                .anyMatch(cocktail -> cocktail % 2 != type);
    }
}