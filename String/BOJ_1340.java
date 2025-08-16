// BOJ - 1340
// Problem Sheet - https://www.acmicpc.net/problem/1340

import java.time.*;
import java.util.*;
import java.io.*;

public class Main {

    static Map<String, Integer> monthMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        monthMap.put("January", 1); monthMap.put("February", 2); monthMap.put("March", 3);
        monthMap.put("April", 4); monthMap.put("May", 5); monthMap.put("June", 6);
        monthMap.put("July", 7); monthMap.put("August", 8); monthMap.put("September", 9);
        monthMap.put("October", 10); monthMap.put("November", 11); monthMap.put("December", 12);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int month = monthMap.get(input[0]);
        int day = Integer.parseInt(input[1].substring(0, 2));
        int year = Integer.parseInt(input[2]);
        String[] time = input[3].split(":");

        long totalSecond = (isLeapYear(year) ? 366 : 365) * 24 * 60 * 60;
        LocalDateTime start = LocalDateTime.of(year, 1, 1, 0, 0, 0);
        LocalDateTime cur = LocalDateTime.of(year, month, day, Integer.parseInt(time[0]), Integer.parseInt(time[1]), 0);
        Duration duration = Duration.between(start, cur);
        long curSecond = duration.getSeconds();
        System.out.println(((double) curSecond / totalSecond) * 100);
        br.close();
    }

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

}