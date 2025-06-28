// BOJ - 27035
// Problem Sheet - https://www.acmicpc.net/problem/27035

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[] male, female;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        male = new int[n];
        for (int i=0 ; i<n ; i++) {
            male[i] = Integer.parseInt(br.readLine());
        }
        female = new int[n];
        for (int i=0 ; i<n ; i++) {
            female[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(male);
        Arrays.sort(female);
        br.close();
    }

    private static int solve() {
        int sum = 0;
        for (int i=0 ; i<n ; i++) {
            sum += Math.abs(male[i] - female[i]);
        }
        return sum;
    }

}