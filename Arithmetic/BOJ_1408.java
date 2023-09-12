// BOJ - 1408
// Problem Sheet - https://www.acmicpc.net/problem/1408

import java.util .*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner(":");

        String[] currentTime = bf.readLine().split(":");
        String[] startTime = bf.readLine().split(":");

        int second = Integer.parseInt(startTime[2]) - Integer.parseInt(currentTime[2]);
        int minute = Integer.parseInt(startTime[1]) - Integer.parseInt(currentTime[1]);
        int hour = Integer.parseInt(startTime[0]) - Integer.parseInt(currentTime[0]);
        if(second < 0) {
            second += 60;
            minute--;
        }
        if(minute < 0) {
            minute += 60;
            hour--;
        }
        if(hour < 0) {
            hour += 24;
        }

        sj.add(String.format("%02d", hour))
                .add(String.format("%02d", minute))
                .add(String.format("%02d", second));
        System.out.println(sj);

        bf.close();
        System.exit(0);
    }
}