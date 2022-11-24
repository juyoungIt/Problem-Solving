// BOJ - 1764
// Problem Sheet - https://www.acmicpc.net/problem/1764

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Set<String> peoples = new HashSet<>();
        List<String> result = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수
        for(int i=0 ; i<n ; i++)
            peoples.add(bf.readLine());

        for(int i=0 ; i<m ; i++) {
            String people = bf.readLine();
            if(peoples.contains(people))
                result.add(people);
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(String people : result)
            System.out.println(people);

        bf.close();
        System.exit(0);
    }
}