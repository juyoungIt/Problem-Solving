// BOJ - 4158
// Problem Sheet - https://www.acmicpc.net/problem/4158

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashSet<Integer> cdSet = new HashSet<>(); // 상근이가 가진 CD의 set

        while(true) {
            int answer = 0;
            cdSet.clear(); // 재사용을 위해 초기화
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken()); // 상근이가 가진 CD의 수
            int m = Integer.parseInt(st.nextToken()); // 선영이가 가진 CD의 수

            if(n == 0 && m == 0) break;

            // 상근이가 가진 CD 정보를 입력받음
            for(int i=0 ; i<n ; i++) {
                int cd = Integer.parseInt(bf.readLine()); // CD 정보를 입력받음
                cdSet.add(cd);
            }

            // 선영이가 가진 CD 정보를 입력받음
            for(int i=0 ; i<m ; i++) {
                int cd = Integer.parseInt(bf.readLine()); // CD 정보를 입력받음
                if(cdSet.contains(cd)) answer++;
            }

            // 종합한 결과를 출력함
            System.out.println(answer);
        }

        bf.close();
        System.exit(0);
    }
}