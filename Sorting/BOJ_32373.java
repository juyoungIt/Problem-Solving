// BOJ - 32373
// Problem Sheet - https://www.acmicpc.net/problem/32373

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<List<Integer>> swapGroups = new ArrayList<>();
        for (int i=0 ; i<k ; i++) {
            swapGroups.add(new ArrayList<>());
        }
        for (int i=0 ; i<N ; i++) {
            swapGroups.get(i % k).add(arr[i]);
        }
        for (int i=0 ; i<k ; i++) {
            Collections.sort(swapGroups.get(i));
        }

        int[] sortedArr = new int[N];
        for (int i=0 ; i<N ; i++) {
            sortedArr[i] = swapGroups.get(i % k).remove(0);
        }

        boolean isValid = true;
        for (int i=0 ; i<N ; i++) {
            if (sortedArr[i] != i) {
                isValid = false;
                break;
            }
        }

        System.out.println(isValid ? "Yes" : "No");
        br.close();
    }
}