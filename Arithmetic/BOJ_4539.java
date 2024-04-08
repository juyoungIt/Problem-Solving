// BOJ - 4539
// Problem Sheet - https://www.acmicpc.net/problem/4539

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i=0 ; i<n ; i++) {
            String value = br.readLine();
            sb.append(getRecRoundValue(value, 0)).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static String getRecRoundValue(String value, int roundIndex) {
        if (roundIndex == value.length()) {
            return value;
        }
        value = String.valueOf((int) (Math.round(Double.parseDouble(value) / Math.pow(10, roundIndex)) * Math.pow(10, roundIndex)));
        return getRecRoundValue(value, roundIndex + 1);
    }
}