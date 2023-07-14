// BOJ - 14670
// Problem Sheet - https://www.acmicpc.net/problem/14670

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        Map<Integer, Integer> medicineMapper = new HashMap<>();
        StringTokenizer st;
        for(int i=0 ; i<N ; i++) {
            st = new StringTokenizer(bf.readLine());
            medicineMapper.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int R = Integer.parseInt(bf.readLine());
        StringBuilder tmp = new StringBuilder();
        for(int i=0 ; i<R ; i++) {
            st = new StringTokenizer(bf.readLine());
            int L = Integer.parseInt(st.nextToken());
            for(int j=0 ; j<L ; j++) {
                int medicine = medicineMapper.getOrDefault(Integer.parseInt(st.nextToken()), -1);
                if(medicine < 0) {
                    tmp.setLength(0);
                    tmp.append("YOU DIED");
                    break;
                }
                tmp.append(medicine).append(" ");
            }
            sb.append(tmp).append("\n");
            tmp.setLength(0);
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}