// BOJ - 25757
// Problem Sheet - https://www.acmicpc.net/problem/25757

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Set<String> players = new HashSet<>(); // 게임에 참여한 사람의 Set

        // Type에 대한 값을 세팅하는 부분
        Map<Character, Integer> typeMapper = new HashMap<>();
        typeMapper.put('Y', 1);
        typeMapper.put('F', 2);
        typeMapper.put('O', 3);

        int n = Integer.parseInt(st.nextToken()); // 플레이할 사람의 수
        int type = typeMapper.get(st.nextToken().charAt(0)); // 플레이할 게임의 종류 (Y:2, F:3, O:4)

        for(int i=0 ; i<n ; i++)
            players.add(bf.readLine());

        System.out.println(players.size() / type);

        bf.close();
        System.exit(0);
    }
}