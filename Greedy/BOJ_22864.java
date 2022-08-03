// BOJ - 22864
// Problem Sheet - https://www.acmicpc.net/problem/22864

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken()); // 일할 때 증가하는 피로도
        int b = Integer.parseInt(st.nextToken()); // 일할 때 할 수 있는 일의 양
        int c = Integer.parseInt(st.nextToken()); // 휴식 시 감소하는 피로도
        int m = Integer.parseInt(st.nextToken()); // 번아웃이 오는 피로도 한계치
        int tiredness = 0, answer = 0; // 피로도, 정답

        for(int i=0 ; i<24 ; i++) {
            if(tiredness+a > m)
                tiredness = (tiredness-c > 0) ? tiredness-c : 0;
            else {
                tiredness += a;
                answer += b;
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}