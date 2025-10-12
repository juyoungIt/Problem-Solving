// BOJ - 5840
// Problem Sheet - https://www.acmicpc.net/problem/5840

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] lastPosition = new int[1_000_001];
        Arrays.fill(lastPosition, - 1);
        int maxBreed = -1;
        for (int i=0 ; i<n ; i++) {
            int breedId = Integer.parseInt(br.readLine());
            if (lastPosition[breedId] > -1) {
                int dist = i - lastPosition[breedId];
                if (dist <= k) {
                    maxBreed = Math.max(maxBreed, breedId);
                }
            }
            lastPosition[breedId] = i;
        }
        System.out.println(maxBreed);
        br.close();
    }
}
