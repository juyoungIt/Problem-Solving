// BOJ - 25496
// Problem Sheet - https://www.acmicpc.net/problem/25496

import java.util.*;
import java.io.*;

public class Main {

    private static final int FATIGUE_THRESHOLD = 200;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] fatigues = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            fatigues[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(fatigues);

        int maxProductionCount = 0;
        for (int i=0 ; i<n ; i++) {
            if (p >= FATIGUE_THRESHOLD) break;
            p += fatigues[i];
            maxProductionCount++;
        }
        System.out.println(maxProductionCount);

        br.close();
        System.exit(0);
    }
}