// BOJ - 24390
// Problem Sheet - https://www.acmicpc.net/problem/24390

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] timeStr = bf.readLine().split(":");
        int[] divider = {600, 60, 30, 10}; // 10분, 1분, 30초, 10초
        int time = Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]); // 남은 조리시간
        boolean started = false; // 조리시작 여부
        int answer = 0; // 필요한 버튼 클릭횟수

        for(int i=0 ; i<4 ; i++) {
            if(time/divider[i] > 0) {
                if(i == 2) {
                    answer += time/divider[i];
                    time %= divider[i];
                    started = true;
                }
                else {
                    answer += time/divider[i];
                    time %= divider[i];
                }
            }
        }

        if(!started) answer++;
        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}