// BOJ - 1620
// Problem Sheet - https://www.acmicpc.net/problem/1620

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Map<Integer, String> nameMapper = new HashMap<>(); // 번호 - 이름
        Map<String, Integer> keyMapper = new HashMap<>(); // 이름 - 번호

        int n = Integer.parseInt(st.nextToken()); // 포켓몬의 수
        int m = Integer.parseInt(st.nextToken()); // 문제의 수
        for(int i=1 ; i<=n ; i++) {
            String name = bf.readLine(); // 포켓몬의 이름
            nameMapper.put(i, name);
            keyMapper.put(name, i);
        }

        for(int i=0 ; i<m ; i++) {
            String question = bf.readLine(); // 질문내용
            if(Character.isDigit(question.charAt(0))) { // 숫자일 경우
                System.out.println(nameMapper.get(Integer.parseInt(question)));
            } else { // 이름일 경우
                System.out.println(keyMapper.get(question));
            }
        }

        bf.close();
        System.exit(0);
    }
}