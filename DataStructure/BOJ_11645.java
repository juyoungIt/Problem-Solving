// BOJ - 11645
// Problem Sheet - https://www.acmicpc.net/problem/11645

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testCaseSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        for(int i=0 ; i<testCaseSize ; i++) {
            Set<String> cities = new HashSet<>(); // 방문한 도시의 Set
            int visitCount = Integer.parseInt(bf.readLine()); // 방문횟수
            for(int j=0 ; j<visitCount ; j++) {
                cities.add(bf.readLine());
            }
            System.out.println(cities.size());
        }

        bf.close();
        System.exit(0);
    }
}