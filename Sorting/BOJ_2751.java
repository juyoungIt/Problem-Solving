// BOJ - 2751
// Problem Sheet - https://www.acmicpc.net/problem/2751

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        int[] numbers = new int[N];
        for(int i=0 ; i<N ; i++) {
            numbers[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(numbers);
        for(int number : numbers) {
            sb.append(number).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}