// BOJ - 13413
// Problem Sheet - https://www.acmicpc.net/problem/13413

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        int[] answers = new int[tcSize]; // 각 테스트 케이스의 정답

        for(int i=0 ; i<tcSize ; i++) {
            int oCount = Integer.parseInt(bf.readLine()); // 오셀로의 수
            String origin = bf.readLine(); // 원래 오셀로 배치
            String goal = bf.readLine();     // 목표 오셀로 배치
            int oCountBlack = 0, oCountWhite = 0; // 목표와 다른 말 중 검정, 흰색의 수
            int increment; // 중간 연산에 사용하는 변수 (증감자)
            for(int j=0 ; j<oCount ; j++) {
                if(origin.charAt(j) != goal.charAt(j)) {
                    if(origin.charAt(j) == 'B')
                        oCountBlack++;
                    else
                        oCountWhite++;
                }
            }
            increment = Math.min(oCountBlack, oCountWhite);
            answers[i] += increment;
            oCountBlack -= increment;
            oCountWhite -= increment;
            answers[i] += (oCountBlack + oCountWhite);
        }

        for(int answer : answers)
            System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}