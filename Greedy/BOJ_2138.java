// BOJ - 2138
// Problem Sheet - https://www.acmicpc.net/problem/2138

import java.util.*;
import java.io.*;

public class Main {
    private static int n; // 전구의 수
    private static char[] start; // 시작하는 전구의 상태를 저장
    private static char[] mid;   // 상태가 변화 중인 전구의 중간상태를 저장
    private static char[] target; // 목표하는 전구의 상태를 저장
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        start = bf.readLine().toCharArray();
        mid = start.clone();
        target = bf.readLine().toCharArray();

        int result1 = execute(true);
        mid = start.clone(); // 재사용을 위해 초기화
        int result2 = execute(false);

        int answer = (Math.min(result1, result2) == -1)
                ? Math.max(result1, result2)
                : Math.min(result1, result2);

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static int execute(boolean pushFirst) {
        int pushCount = 0; // 스위치를 클릭한 횟수
        if(pushFirst) {
            pushSwitch(0);
            pushCount++;
        }
        for(int i=1 ; i<n ; i++) {
            if(mid[i-1] != target[i-1]) {
                pushSwitch(i);
                pushCount++;
            }
        }
        return (!Arrays.equals(mid, target)) ? -1 : pushCount;
    }

    static void pushSwitch(int i) {
        if(i == 0) {
            mid[0] = changeStatus(mid[0]);
            mid[1] = changeStatus(mid[1]);
        }
        else if(i == n-1) {
            mid[n-1] = changeStatus(mid[n-1]);
            mid[n-2] = changeStatus(mid[n-2]);
        }
        else {
            mid[i] = changeStatus(mid[i]);
            mid[i-1] = changeStatus(mid[i-1]);
            mid[i+1] = changeStatus(mid[i+1]);
        }
    }

    static char changeStatus(char s) {
        return (s == '1') ? '0' : '1';
    }
}