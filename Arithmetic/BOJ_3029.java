// BOJ - 3029
// Problem Sheet - https://www.acmicpc.net/problem/3029

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] curTime = getTimeToken(bf.readLine());
        int[] throwTime = getTimeToken(bf.readLine());
        throwTime[2] = calculator(curTime, throwTime, 2);
        throwTime[1] = calculator(curTime, throwTime, 1);
        throwTime[0] = calculator(curTime, throwTime, 0);

        if(throwTime[0] == 0 && throwTime[1] == 0 && throwTime[2] == 0) {
            throwTime[0] += 24;
        }
        System.out.printf("%02d:%02d:%02d\n", throwTime[0], throwTime[1], throwTime[2]);

        bf.close();
        System.exit(0);
    }

    private static int[] getTimeToken(String timeStr) {
        return Arrays.stream(timeStr.split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int calculator(int[] timeA, int[] timeB, int idx) {
        if(idx > 0) {
            timeB[idx] = timeB[idx] - timeA[idx];
            if(timeB[idx] < 0) {
                timeB[idx] += 60;
                timeB[idx-1]--;
            }
            return timeB[idx];
        } else {
            timeB[idx] = timeB[idx] - timeA[idx];
            if(timeB[idx] < 0) {
                timeB[idx] += 24;
            }
            return timeB[idx];
        }
    }
}