// BOJ - 23278
// Problem Sheet - https://www.acmicpc.net/problem/23278

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] scores = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int sum = 0;
        for (int i=l ; i<n-h ; i++) {
            sum += scores[i];
        }
        System.out.println((double) sum / (n - (l + h)));

        br.close();
        System.exit(0);
    }
}