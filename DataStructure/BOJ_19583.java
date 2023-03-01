// BOJ - 19583
// Problem Sheet - https://www.acmicpc.net/problem/19583

import java.time.LocalTime;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Set<String> attendees = new HashSet<>();
        Set<String> finalSet = new HashSet<>(); // 최종 출석자들

        LocalTime startTime = convertToLocalTime(st.nextToken());
        LocalTime endTime = convertToLocalTime(st.nextToken());
        LocalTime finishTime = convertToLocalTime(st.nextToken());

        String log = "";
        LocalTime logTime;
        String logName;
        while(true) {
            log = bf.readLine();
            if(log == null || log.equals("")) {
                break;
            }
            String[] tokens = log.split(" ");
            logTime = convertToLocalTime(tokens[0]);
            logName = tokens[1];

            if(isBeforeOnTime(startTime, logTime)) {
                attendees.add(logName);
            } else if(attendees.contains(logName) && isBetween(endTime, finishTime, logTime)) {
                finalSet.add(logName);
            }
        }

        System.out.println(finalSet.size());

        bf.close();
        System.exit(0);
    }

    private static LocalTime convertToLocalTime(String timeStr) {
        String[] timeTokens = timeStr.split(":");
        int hours = Integer.parseInt(timeTokens[0]);
        int minutes = Integer.parseInt(timeTokens[1]);

        return LocalTime.of(hours, minutes);
    }

    private static boolean isBeforeOnTime(LocalTime targetTime, LocalTime curTime) {
        return curTime.isBefore(targetTime) || curTime.equals(targetTime);
    }

    private static boolean isAfterOnTime(LocalTime targetTime, LocalTime curTime) {
        return curTime.isAfter(targetTime) || curTime.equals(targetTime);
    }

    private static boolean isBetween(LocalTime timeA, LocalTime timeB, LocalTime curTime) {
        return isAfterOnTime(timeA, curTime) && isBeforeOnTime(timeB, curTime);
    }
}