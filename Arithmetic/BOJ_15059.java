// BOJ - 15059
// Problem Sheet - https://www.acmicpc.net/problem/15059

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inventory = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] requirement = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int insufficient = 0;
        for (int i=0 ; i<inventory.length ; i++) {
            int difference = requirement[i] - inventory[i];
            insufficient += Math.max(difference, 0);
        }

        System.out.println(insufficient);

        br.close();
        System.exit(0);
    }
}