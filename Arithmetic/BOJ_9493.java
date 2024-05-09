// BOJ - 9493
// Problem Sheet - https://www.acmicpc.net/problem/9493

import java.util.*;
import java.io.*;

public class Main {

    private static final String OUTPUT_FORMAT = "%d:%02d:%02d\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // km
            int a = Integer.parseInt(st.nextToken()); // km/h -> 1시간 동안 이 정도를 간다!
            int b = Integer.parseInt(st.nextToken()); // km/h -> 1시간 동안 이 정도를 간다!
            if (m == 0 && a == 0 && b == 0) break;
            double secondA = ((double) m / a) * 3600;
            double secondB = ((double) m / b) * 3600;
            int diff = (int) Math.round(Math.abs(secondA - secondB));
            sb.append(convertSecondToTimeString(diff));
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static String convertSecondToTimeString(int second) {
        int hour = second / 3600;
        int minute = second % 3600 / 60;
        int seconds = second % 3600 % 60;
        return String.format(OUTPUT_FORMAT, hour, minute, seconds);
    }
}