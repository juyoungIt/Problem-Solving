// BOJ - 15312
// Problem Sheet - https://www.acmicpc.net/problem/15312

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
        String a = br.readLine();
        String b = br.readLine();
        int size = a.length() + b.length();
        int[][] arr = new int[size][size];
        int index = 0;
        for (int i=0 ; i<a.length() ; i++) {
            arr[0][index] = numbers[a.charAt(i) - 'A'];
            index += 2;
        }
        index = 1;
        for (int i=0 ; i<b.length() ; i++) {
            arr[0][index] = numbers[b.charAt(i) - 'A'];
            index += 2;
        }

        for (int i=0 ; i<size ; i++) {
            for (int j=0 ; j<size-1-i ; j++) {
                arr[i + 1][j] = (arr[i][j] + arr[i][j + 1]) % 10;
            }
        }

        System.out.printf("%02d\n", arr[size - 2][0] * 10 + arr[size - 2][1]);
        br.close();
    }
}