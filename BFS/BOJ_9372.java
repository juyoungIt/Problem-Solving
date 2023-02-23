// BOJ - 9372
// Problem Sheet - https://www.acmicpc.net/problem/9372

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCaseCount = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<testCaseCount ; i++) {
            st = new StringTokenizer(bf.readLine());
            int numberOfCountries = Integer.parseInt(st.nextToken());
            int numberOfPlanes = Integer.parseInt(st.nextToken());
            // build adjacency list
            List<Integer>[] al = new LinkedList[numberOfCountries+1];
            boolean[] visit = new boolean[numberOfCountries+1];
            for(int j=1 ; j<=numberOfCountries ; j++) {
                al[j] = new LinkedList<>();
            }
            for(int j=0 ; j<numberOfPlanes ; j++) {
                st = new StringTokenizer(bf.readLine());
                int countryA = Integer.parseInt(st.nextToken());
                int countryB = Integer.parseInt(st.nextToken());
                al[countryA].add(countryB);
                al[countryB].add(countryA);
            }
            sb.append(bfs(al, visit)).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int bfs(List<Integer>[] al, boolean[] visit) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        queue.add(1);
        visit[1] = true;
        while(!queue.isEmpty()) {
            int currentCountry = queue.peek();
            for(int country : al[currentCountry]) {
                if(!visit[country]) {
                    queue.add(country);
                    visit[country] = true;
                    count++;
                }
            }
            queue.poll();
        }
        return count;
    }
}