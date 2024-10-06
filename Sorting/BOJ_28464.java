// BOJ - 28464
// Problem Sheet - https://www.acmicpc.net/problem/28464

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] potatoes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(potatoes);

        int left = 0;
        int right = n - 1;
        int[] totalPotatoes = new int[2];
        while (left <= right) {
            if (left == right) {
                totalPotatoes[1] += potatoes[right];
                break;
            }
            totalPotatoes[0] += potatoes[left++];
            totalPotatoes[1] += potatoes[right--];
        }
        System.out.printf("%d %d\n", totalPotatoes[0], totalPotatoes[1]);

        br.close();
        System.exit(0);
    }
}