// BOJ - 18870
// Problem Sheet - https://www.acmicpc.net/problem/18870

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfCoordinates = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] coordinates = new int[numberOfCoordinates];
        Set<Integer> uniqueCoordinates = new TreeSet<>();
        for(int i=0 ; i<numberOfCoordinates ; i++) {
            coordinates[i] = Integer.parseInt(st.nextToken());
            uniqueCoordinates.add(coordinates[i]);
        }

        Map<Integer, Integer> indexes = new HashMap<>();
        int currentIndex = 0;
        for(int uniqueCoordinate : uniqueCoordinates) {
            indexes.put(uniqueCoordinate, currentIndex++);
        }

        for(int coordinate : coordinates) {
            sb.append(indexes.get(coordinate)).append(" ");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}