// BOJ - 14425
// Problem Sheet - https://www.acmicpc.net/problem/14425

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Set<String> stringSet = new HashSet<>(); // 문자열로 구성된 Set
        int answer = 0;

        int n = Integer.parseInt(st.nextToken()); // 집합S가 가지는 문자열의 갯수
        int m = Integer.parseInt(st.nextToken()); // 입력으로 주어지는 문자열의 수
        for(int i=0 ; i<n ; i++)
            stringSet.add(bf.readLine());

        for(int i=0 ; i<m ; i++) {
            String str = bf.readLine();
            if(stringSet.contains(str))
                answer++;
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}