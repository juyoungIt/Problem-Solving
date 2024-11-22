// BOJ - 11597
// Problem Sheet - https://www.acmicpc.net/problem/11597

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] ratings = new int[n];
        for (int i=0 ; i<n ; i++) {
            ratings[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ratings);

        int maxX = ratings[0] + ratings[n - 1];
        for (int i=0 ; i<n/2 ; i++) {
            int rating = ratings[i] + ratings[n - 1 - i];
            if (rating < maxX) {
                maxX = rating;
            }
        }

        System.out.println(maxX);
        br.close();
    }
}