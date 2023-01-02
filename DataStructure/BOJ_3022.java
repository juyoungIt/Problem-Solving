// BOJ - 3022
// Problem Sheet - https://www.acmicpc.net/problem/3022

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> countMapper = new HashMap<>(); // 카운트 정보를 유지하는 map
        int warning = 0; // 경로를 준 횟수

        int n = Integer.parseInt(bf.readLine());
        for(int i=1 ; i<=n ; i++) {
            String name = bf.readLine(); // 이름을 입력받은 부분

            // 현재 음식을 먹으려는 아이가 먹은 음식의 양이 다른 아이들이 먹은 음식의 양보다 많다면?
            // => 해당 아이에게 경고해야 함
            if(countMapper.containsKey(name) && countMapper.get(name) * 2 > i-1) {
                warning++; // 해당 어린이에게 경고함
            }

            // 음식을 받아간 정보를 추가함
            if(countMapper.containsKey(name)) {
                countMapper.put(name, countMapper.get(name) + 1);
            } else {
                countMapper.put(name, 1);
            }
        }

        // 종합된 결과를 출력함
        System.out.println(warning);

        bf.close();
        System.exit(0);
    }
}