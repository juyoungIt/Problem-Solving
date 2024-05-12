// BOJ - 29807
// Problem Sheet - https://www.acmicpc.net/problem/29807

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] scores = new int[5];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<t ; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int studentNumber = 0;

        /* 국어 vs 영어 */
        if (scores[0] > scores[2]) studentNumber += Math.abs(scores[0] - scores[2]) * 508;
        else studentNumber += Math.abs(scores[0] - scores[2]) * 108;

        /* 수학 vs 탐구 */
        if (scores[1] > scores[3]) studentNumber += Math.abs(scores[1] - scores[3]) * 212;
        else studentNumber += Math.abs(scores[1] - scores[3]) * 305;

        /* 제2 외국어 */
        if (t > 4) studentNumber += scores[4] * 707;
        System.out.println(studentNumber * 4763);

        br.close();
        System.exit(0);
    }
}