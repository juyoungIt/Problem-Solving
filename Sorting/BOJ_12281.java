// BOJ - 12281
// Problem Sheet - https://www.acmicpc.net/problem/12281

import java.util.*;
import java.io.*;

public class Main {

    private static final String OUTPUT_FORMAT = "Case #%d: %s\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=t ; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            List<Integer> alexBooks = new ArrayList<>();
            List<Integer> bobBooks = new ArrayList<>();
            List<Integer> alexIndexes = new ArrayList<>();
            List<Integer> bobIndexes = new ArrayList<>();
            String[] row = br.readLine().split(" ");
            for (int j=0 ; j<n ; j++) {
                arr[j] = Integer.parseInt(row[j]);
                if (Math.abs(arr[j] % 2) == 1) {
                    alexBooks.add(arr[j]);
                    alexIndexes.add(j);
                } else {
                    bobBooks.add(arr[j]);
                    bobIndexes.add(j);
                }
            }
            Collections.sort(alexBooks);
            bobBooks.sort(Collections.reverseOrder());

            for (int j=0 ; j<alexBooks.size() ; j++) {
                arr[alexIndexes.get(j)] = alexBooks.get(j);
            }

            for (int j=0 ; j<bobBooks.size() ; j++) {
                arr[bobIndexes.get(j)] = bobBooks.get(j);
            }

            StringBuilder buffer = new StringBuilder();
            for (int element : arr) {
                buffer.append(element).append(" ");
            }
            sb.append(String.format(OUTPUT_FORMAT, i, buffer));
        }

        System.out.println(sb);
        br.close();
    }
}