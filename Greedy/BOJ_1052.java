// BOJ - 1052
// Problem Sheet - https://www.acmicpc.net/problem/1052

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 물병의 수
        int k = Integer.parseInt(st.nextToken()); // 한 번에 옮길 수 있는 물병의 최대 수
        List<Integer> remainders = new LinkedList<>();
        long answer = 0;

        if(n > k) {
            int tmp = n, increment = 1;
            // 일단 합칠 수 있는대로 모두 합침
            while(tmp != 0) {
                if(tmp%2 == 1)
                    remainders.add(increment);
                tmp = tmp >> 1; // 2로 나눔
                increment = increment << 1; // 2를 곱함
            }
            while(remainders.size() > k) {
                if(remainders.get(0) == remainders.get(1)) {
                    remainders.set(1, remainders.get(0) << 1);
                    remainders.remove(0);
                    continue;
                }
                answer += remainders.get(1) - remainders.get(0);
                remainders.set(1, remainders.get(1) << 1);
                remainders.remove(0);
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}