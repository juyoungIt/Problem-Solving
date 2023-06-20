// BOJ - 18870
// Problem Sheet - https://www.acmicpc.net/problem/18870

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfCoordinate = Integer.parseInt(bf.readLine());
        int[] coordinates = new int[numberOfCoordinate];
        int[] sortedCoordinates = new int[numberOfCoordinate];
        Map<Integer, Integer> rankMapper = new HashMap<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfCoordinate ; i++) {
            coordinates[i] = Integer.parseInt(st.nextToken());
            sortedCoordinates[i] = coordinates[i];
        }
        Arrays.sort(sortedCoordinates);

        int currentRank = 0;
        for(int coordinate : sortedCoordinates) {
            if(!rankMapper.containsKey(coordinate)) {
                rankMapper.put(coordinate, currentRank++);
            }
        }

        for(int coordinate : coordinates) {
            sb.append(rankMapper.get(coordinate)).append(" ");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}