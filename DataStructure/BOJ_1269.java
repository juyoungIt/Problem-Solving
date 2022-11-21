// BOJ - 1269
// Problem Sheet - https://www.acmicpc.net/problem/1269

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Set<Integer> union = new HashSet<>(); // 두 집합의 합집합 원소를 저장
        Set<Integer> intersection = new HashSet<>(); // 두 집합의 교집합 원소를 저장

        // 집합의 정보를 입력받아 구성하는 부분
        // 핵심 - 두 집합의 합집합에서 교집합만 빼면 됨
        int numberOfA = Integer.parseInt(st.nextToken()); // 집합 A의 원소의 갯수
        int numberOfB = Integer.parseInt(st.nextToken()); // 집합 B의 원소의 갯수
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfA ; i++)
            union.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfB ; i++) {
            int element = Integer.parseInt(st.nextToken());
            if(union.contains(element))
                intersection.add(element);
            union.add(element);
        }

        System.out.println(union.size() - intersection.size());

        bf.close();
        System.exit(0);
    }
}