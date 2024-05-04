// BOJ - 17284
// Problem Sheet - https://www.acmicpc.net/problem/17284

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalPrice = 0;
        int[] clickCodes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int clickCode : clickCodes) {
            totalPrice += getPrice(clickCode);
        }

        System.out.println(5000 - totalPrice);

        br.close();
        System.exit(0);
    }

    private static int getPrice(int code) {
        if (code == 1) return 500;
        else if (code == 2) return 800;
        else return 1_000;
    }
}