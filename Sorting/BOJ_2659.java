// BOJ - 2659
// Problem Sheet - https://www.acmicpc.net/problem/2659

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        while (st.hasMoreElements()) {
            deque.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> allClockNumbers = getAllClockNumbers();
        int clockNumber = getClockNumber(deque);
        int topology = getClockNumberTopology(allClockNumbers, clockNumber);
        System.out.println(topology);

        br.close();
    }

    private static int getClockNumber(Deque<Integer> deque) {
        List<Integer> cases = new ArrayList<>(4);
        int value = 0;
        for (int i=0 ; i<4 ; i++) {
            for (int j=3 ; j>=0 ; j--) {
                value += deque.getFirst() * ((int) Math.pow(10, j));
                deque.addLast(deque.pollFirst());
            }
            deque.addLast(deque.pollFirst());
            cases.add(value);
            value = 0;
        }
        Collections.sort(cases);
        return cases.get(0);
    }

    private static List<Integer> getAllClockNumbers() {
        List<Integer> clockNumbers = new ArrayList<>();
        Set<Integer> clockNumberSet = new HashSet<>();
        for (int i=1 ; i<=9 ; i++) {
            for (int j=1 ; j<=9 ; j++) {
                for (int k=1 ; k<=9 ; k++) {
                    for (int l=1 ; l<=9 ; l++) {
                        Deque<Integer> deque = new ArrayDeque<>(List.of(i, j, k, l));
                        clockNumberSet.add(getClockNumber(deque));
                    }
                }
            }
        }
        return clockNumberSet.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static int getClockNumberTopology(List<Integer> clockNumbers, int target) {
        int topology = 0;
        for (int clockNumber : clockNumbers) {
            if (clockNumber == target) {
                topology++;
                break;
            }
            topology++;
        }
        return topology;
    }
}