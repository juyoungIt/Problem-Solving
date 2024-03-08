// BOJ - 8723
// Problem Sheet - https://www.acmicpc.net/problem/8723

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sides = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(sides);

        System.out.println(getTriangleType(sides));

        br.close();
        System.exit(0);
    }

    private static int getTriangleType(int[] sides) {
        if ((int) Math.pow(sides[2], 2) == (int) Math.pow(sides[0], 2) + (int) Math.pow(sides[1], 2)) {
            return 1;
        } else if (sides[0] == sides[1] && sides[1] == sides[2]) {
            return 2;
        } else {
            return 0;
        }
    }
}