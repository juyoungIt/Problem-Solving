// BOJ - 5928
// Problem Sheet - https://www.acmicpc.net/problem/5928

import java.time.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LocalDateTime startDateTime = LocalDateTime.of(2011, 11, 11, 11, 11);
        LocalDateTime endDateTime = LocalDateTime.of(2011,11, d, h, m);
        long duration = Duration.between(startDateTime, endDateTime).toMinutes();

        System.out.println(duration >= 0 ? duration : -1);

        br.close();
        System.exit(0);
    }
}