// BOJ - 26069
// Problem Sheet - https://www.acmicpc.net/problem/26069

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<String> dancer = new HashSet<>(); // 춤을 추는 사람
        dancer.add("ChongChong"); // 초기값 추가

        int n = Integer.parseInt(bf.readLine()); // 기록의 수
        for(int i=0 ; i<n ; i++) {
            String[] person = bf.readLine().split(" ");
            if(dancer.contains(person[0]) && !dancer.contains(person[1]))
                dancer.add(person[1]);
            else if(dancer.contains(person[1]) && !dancer.contains(person[0]))
                dancer.add(person[0]);
        }

        System.out.println(dancer.size());

        bf.close();
        System.exit(0);
    }
}