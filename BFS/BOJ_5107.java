// BOJ - 5107
// Problem Sheet - https://www.acmicpc.net/problem/5107

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfTestCase = 0;
        Map<String, List<String>> al = new HashMap<>(); // adjacency list
        Map<String, Boolean> isVisit = new HashMap<>();
        while(true) {
            al.clear();
            isVisit.clear();
            numberOfTestCase++;
            int numberOfCycleRelations = 0;

            int numberOfPeople = Integer.parseInt(bf.readLine());
            if(numberOfPeople == 0) {
                break;
            }

            for(int i=0 ; i<numberOfPeople ; i++) {
                String[] peoples = bf.readLine().split(" ");
                if(!al.containsKey(peoples[0])) {
                    al.put(peoples[0], new LinkedList<>());
                }
                al.get(peoples[0]).add(peoples[1]);
                isVisit.put(peoples[0], false);
            }

            for(String name : al.keySet()) {
                if(!isVisit.get(name) && isCircleRelation(al, isVisit, name)) {
                    numberOfCycleRelations++;
                }
            }
            sb.append(numberOfTestCase).append(" ").append(numberOfCycleRelations).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    static boolean isCircleRelation(Map<String, List<String>> al, Map<String, Boolean> isVisit, String name) {
        Queue<String> queue = new LinkedList<>();

        queue.add(name);
        while(!queue.isEmpty()) {
            for(String people : al.get(queue.peek())) {
                if(!isVisit.get(people)) {
                    queue.add(people);
                    isVisit.put(people, true);
                }
            }
            queue.poll();
        }

        return isVisit.get(name);
    }
}