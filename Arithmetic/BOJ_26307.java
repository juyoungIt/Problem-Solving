// BOJ - 26307
// Problem Sheet - https://www.acmicpc.net/problem/26307

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(h, m);

        Duration duration = Duration.between(startTime, endTime);
        System.out.println(duration.toMinutes());

        br.close();
        System.exit(0);
    }
}