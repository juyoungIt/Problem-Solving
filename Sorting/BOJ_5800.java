// BOJ - 5800
// Problem Sheet - https://www.acmicpc.net/problem/5800

import java.util.*;
import java.io.*;

public class Main {

    private static final String MESSAGE_FORMAT = "Class %d\nMax %d, Min %d, Largest gap %d\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        for (int i=0 ; i<k ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Integer[] scores = new Integer[n];
            for (int j=0 ; j<n ; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(scores, Collections.reverseOrder());
            int max = scores[0];
            int min = scores[n - 1];
            int maxGap = -1;
            for (int j=0 ; j<n-1 ; j++) {
                int gap = scores[j] - scores[j + 1];
                if (maxGap < gap) {
                    maxGap = gap;
                }
            }
            sb.append(String.format(MESSAGE_FORMAT, i + 1, max, min, maxGap));
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}