// BOJ - 15080
// Problem Sheet - https://www.acmicpc.net/problem/15080

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] departure = Arrays.stream(br.readLine().split(" : "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] arrival = Arrays.stream(br.readLine().split(" : "))
                .mapToInt(Integer::parseInt)
                .toArray();

        LocalTime departureTime = LocalTime.of(departure[0], departure[1], departure[2]);
        LocalTime arrivalTime = LocalTime.of(arrival[0], arrival[1], arrival[2]);

        Duration duration = Duration.between(departureTime, arrivalTime);
        long result = duration.getSeconds();
        if (result < 0) {
            result += 60 * 60 * 24;
        }

        System.out.println(result);

        br.close();
        System.exit(0);
    }
}