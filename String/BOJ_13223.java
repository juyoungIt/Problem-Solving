// BOJ - 13223
// Problem Sheet - https://www.acmicpc.net/problem/13223

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] currentTime = bf.readLine().split(":");
        String[] executionTime = bf.readLine().split(":");

        int currentTimeBySecond = convertToSecondUnit(currentTime);
        int executionTimeBySecond = convertToSecondUnit(executionTime);
        if(currentTimeBySecond >= executionTimeBySecond) {
            executionTimeBySecond += 24 * 3600;
        }

        System.out.println(getTimeFormat(executionTimeBySecond-currentTimeBySecond));

        bf.close();
        System.exit(0);
    }

    private static int convertToSecondUnit(String[] time) {
        return Integer.parseInt(time[0]) * 3600
                + Integer.parseInt(time[1]) * 60
                + Integer.parseInt(time[2]);
    }

    private static String getTimeFormat(int secondUnit) {

        int hour = secondUnit/3600;
        int minute = secondUnit%3600/60;
        int second = secondUnit%60;

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}