// BOJ - 13698
// Problem Sheet - https://www.acmicpc.net/problem/13698

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cups = new int[4];
        cups[0] = 1;
        cups[3] = 2;
        String mix = br.readLine();
        for (int i=0 ; i<mix.length() ; i++) {
            char type = mix.charAt(i);
            if (type == 'A') swap(cups, 0, 1);
            else if (type == 'B') swap(cups, 0, 2);
            else if (type == 'C') swap(cups, 0, 3);
            else if (type == 'D') swap(cups, 1, 2);
            else if (type == 'E') swap(cups, 1, 3);
            else swap(cups, 2, 3);
        }
        int min = -1, max = -1;
        for (int i=0 ; i<4 ; i++) {
            if (cups[i] == 1) min = i + 1;
            if (cups[i] == 2) max = i + 1;
        }
        System.out.printf("%d\n%d\n", min, max);
        br.close();
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
