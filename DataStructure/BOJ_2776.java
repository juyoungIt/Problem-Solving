// BOJ - 2776
// Problem Sheet - https://www.acmicpc.net/problem/2776

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수

        StringTokenizer st;
        for(int i=0 ; i<tcSize ; i++) {
            int n = Integer.parseInt(bf.readLine()); // 수첩 1에 적힌 정수의 수
            Set<Integer> realNumbers = new HashSet<>(); // 실제로 본 수의 set
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<n ; j++)
                realNumbers.add(Integer.parseInt(st.nextToken()));

            int m = Integer.parseInt(bf.readLine()); // 수첩 2에 적힌 정수의 수
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<m ; j++) {
                if(realNumbers.contains(Integer.parseInt(st.nextToken())))
                    bw.write("1\n");
                else
                    bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
        bf.close();
        System.exit(0);
    }
}